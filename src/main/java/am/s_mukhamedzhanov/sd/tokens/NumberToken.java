package am.s_mukhamedzhanov.sd.tokens;

public class NumberToken implements Token {
    private final int value;

    public NumberToken(int value) {
        this.value = value;
    }

    @Override
    public TokenType getType() {
        return TokenType.NUM;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NUM(" + value + ")";
    }
}
