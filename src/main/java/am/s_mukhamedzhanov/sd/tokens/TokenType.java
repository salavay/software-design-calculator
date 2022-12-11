package am.s_mukhamedzhanov.sd.tokens;

import java.util.Set;

public enum TokenType {

    NUM,
    OP_BRACKET('('),
    CL_BRACKET(')'),
    BEGIN,
    END,
    PLUS('+'),
    MINUS('-'),
    MUL('*'),
    DIV('/');

    private static final Set<TokenType> operations = Set.of(PLUS, MINUS, MUL, DIV);
    private static final Set<TokenType> brackets = Set.of(CL_BRACKET, OP_BRACKET);


    private char constructChar;

    TokenType(char constructChar) {
        this.constructChar = constructChar;
    }

    TokenType() {
    }

    public static TokenType fromChar(char fromChar) {
        for (TokenType value : TokenType.values()) {
            if (value.constructChar == fromChar) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid char for tokenType");
    }

    public boolean isOp() {
        return operations.contains(this);
    }

    public boolean isBr() {
        return brackets.contains(this);
    }

    public int getPriority() {
        if (isBr()) return 0;
        if (this == PLUS || this == MINUS) return 1;
        if (this == MUL || this == DIV) return 2;
        return 3;
    }
}
