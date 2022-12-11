package am.s_mukhamedzhanov.sd.visitors;

import am.s_mukhamedzhanov.sd.tokens.BraceToken;
import am.s_mukhamedzhanov.sd.tokens.NumberToken;
import am.s_mukhamedzhanov.sd.tokens.Token;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CalcVisitor extends TokenVisitor {

    private Deque<Integer> stack = new ArrayDeque<>();

    public Integer calc(List<Token> tokens) {
        stack = new ArrayDeque<>();
        for (Token token : tokens) {
            token.accept(this);
        }
        return stack.pollLast();
    }


    @Override
    protected void visitNumber(Token token) {
        stack.add(((NumberToken) token).getValue());
    }

    @Override
    protected void visitOp(Token token) {
        if (stack.size() < 2) {
            throw new IllegalStateException();
        }
        int right = stack.pollLast();
        int left = stack.pollLast();
        switch (token.getType()) {
            case DIV -> stack.add(left / right);
            case MUL -> stack.add(left * right);
            case PLUS -> stack.add(left + right);
            case MINUS -> stack.add(left - right);
        }
    }

    @Override
    protected void visitBr(Token token) {}
}
