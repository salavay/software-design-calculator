package am.s_mukhamedzhanov.sd.states;

import am.s_mukhamedzhanov.sd.tokens.Token;
import am.s_mukhamedzhanov.sd.tokens.Tokenizer;

public interface State {
    Token createToken(Tokenizer tokenizer);

    State getNextState(Tokenizer tokenizer);

    static State start() {
        return new StartState();
    }

}
