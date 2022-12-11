package am.s_mukhamedzhanov.sd.tokens;

import am.s_mukhamedzhanov.sd.visitors.TokenVisitor;

public interface Token {
    default void accept(TokenVisitor visitor) {
        visitor.visit(this);
    };

    TokenType getType();
}
