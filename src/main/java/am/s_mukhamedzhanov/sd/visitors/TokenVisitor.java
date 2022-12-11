package am.s_mukhamedzhanov.sd.visitors;

import am.s_mukhamedzhanov.sd.tokens.Token;
import am.s_mukhamedzhanov.sd.tokens.TokenType;

public abstract class TokenVisitor {
    protected abstract void visitNumber(Token token);
    protected abstract void visitOp(Token token);
    protected abstract void visitBr(Token token);
    public void visit(Token token) {
        TokenType type = token.getType();
        if (type.isOp()) {
            visitOp(token);
        } else if (type.isBr()) {
            visitBr(token);
        } else if (type == TokenType.NUM) {
            visitNumber(token);
        } else {
            // todo
        }
    }
}
