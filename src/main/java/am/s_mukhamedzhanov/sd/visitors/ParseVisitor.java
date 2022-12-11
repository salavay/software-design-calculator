package am.s_mukhamedzhanov.sd.visitors;

import am.s_mukhamedzhanov.sd.tokens.Token;
import am.s_mukhamedzhanov.sd.tokens.TokenType;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ParseVisitor extends TokenVisitor {

    private final Deque<Token> stack = new ArrayDeque<>();
    private final List<Token> parseTokens = new ArrayList<>();

    public List<Token> parse(List<Token> tokens) {
        for (Token token : tokens) {
            token.accept(this);
        }
        while (!stack.isEmpty()) {
            parseTokens.add(stack.pollLast());
        }

        return new ArrayList<>(parseTokens);
    }

    @Override
    protected void visitNumber(Token token) {
        parseTokens.add(token);
    }

    @Override
    protected void visitOp(Token token) {
        if (!stack.isEmpty()) {
            Token nextToken = stack.peekLast();
            while (!stack.isEmpty() &&
                    token.getType().getPriority() <= nextToken.getType().getPriority()) {
                parseTokens.add(stack.pollLast());
                nextToken = stack.peekLast();
            }
        }
        stack.add(token);
    }

    @Override
    protected void visitBr(Token token) {
        if (token.getType() == TokenType.OP_BRACKET) {
            stack.add(token);
        } else {
            if (stack.isEmpty()) return;
            Token curToken = stack.pollLast();
            while (!stack.isEmpty() &&
                    curToken.getType() != TokenType.OP_BRACKET) {
                parseTokens.add(curToken);
                curToken = stack.pollLast();
            }
        }
    }
}
