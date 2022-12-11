package am.s_mukhamedzhanov.sd.states;

import am.s_mukhamedzhanov.sd.tokens.Token;
import am.s_mukhamedzhanov.sd.tokens.Tokenizer;

public record ErrorState(String msg) implements State {

    @Override
    public Token createToken(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public State getNextState(Tokenizer tokenizer) {
        return this;
    }
}
