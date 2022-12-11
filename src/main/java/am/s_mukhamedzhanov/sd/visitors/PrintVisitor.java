package am.s_mukhamedzhanov.sd.visitors;

import am.s_mukhamedzhanov.sd.tokens.Token;

import java.util.List;

public class PrintVisitor extends TokenVisitor {
    StringBuilder builder = new StringBuilder();

    public String print(List<Token> tokens) {
        builder = new StringBuilder();
        for (Token token : tokens) {
            token.accept(this);
        }
        return builder.toString();
    }

    public void print(Token token) {
        builder.append(token).append(" ");
    }

    @Override
    protected void visitNumber(Token token) {
        print(token);
    }

    @Override
    protected void visitOp(Token token) {
        print(token);
    }

    @Override
    protected void visitBr(Token token) {
        print(token);
    }
}
