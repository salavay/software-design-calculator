package am.s_mukhamedzhanov.sd.states;

import am.s_mukhamedzhanov.sd.tokens.*;

import java.util.HashMap;
import java.util.Map;

public class StartState implements State {
    @Override
    public Token createToken(Tokenizer tokenizer) {
        char curChar = tokenizer.getCurChar();
        tokenizer.next();
        TokenType tokenType;
        try {
            tokenType = TokenType.fromChar(curChar);
        } catch (IllegalArgumentException e) {
            // todo
            return null;
        }
        return switch (tokenType) {
            case CL_BRACKET, OP_BRACKET -> new BraceToken(tokenType);
            default -> new OperationToken(tokenType);
        };
    }

    @Override
    public State getNextState(Tokenizer tokenizer) {
        if (tokenizer.isEOF()) return new EndState();
        if (tokenizer.isNumber()) return new NumberState();
        if (tokenizer.isOpOrBr()) return new StartState();
        return new ErrorState("Invalid character: " + tokenizer.getCurChar());
    }
}
