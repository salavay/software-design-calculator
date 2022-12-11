package am.s_mukhamedzhanov.sd.states;

import am.s_mukhamedzhanov.sd.tokens.NumberToken;
import am.s_mukhamedzhanov.sd.tokens.Token;
import am.s_mukhamedzhanov.sd.tokens.Tokenizer;

public class NumberState implements State {
    @Override
    public Token createToken(Tokenizer tokenizer) {
        StringBuilder sb = new StringBuilder();
        while (!tokenizer.isEOF() && tokenizer.isNumber()) {
            sb.append(tokenizer.getCurChar());
            tokenizer.next();
        }
        int value = Integer.parseInt(sb.toString());
        return new NumberToken(value);
    }

    @Override
    public State getNextState(Tokenizer tokenizer) {
        if (tokenizer.isEOF()) return new EndState();
        if (tokenizer.isOpOrBr()) return new StartState();
        return new ErrorState("Unknown symbol after number: " + tokenizer.getCurChar());
    }
}
