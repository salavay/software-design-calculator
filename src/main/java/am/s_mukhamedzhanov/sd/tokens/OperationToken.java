package am.s_mukhamedzhanov.sd.tokens;

public class OperationToken implements Token {
    private final TokenType operation;

    public OperationToken(TokenType operation) {
        this.operation = operation;
    }

    @Override
    public TokenType getType() {
        return operation;
    }

    @Override
    public String toString() {
        return operation.name();
    }
}
