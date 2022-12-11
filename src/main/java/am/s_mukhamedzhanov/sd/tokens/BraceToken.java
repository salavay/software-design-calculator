package am.s_mukhamedzhanov.sd.tokens;

import am.s_mukhamedzhanov.sd.visitors.TokenVisitor;

public class BraceToken implements Token {
    private final TokenType tokenType;

    public BraceToken(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public TokenType getType() {
        return tokenType;
    }

    @Override
    public String toString() {
        return tokenType == TokenType.OP_BRACKET ? "LEFT" : "RIGHT";
    }
}
