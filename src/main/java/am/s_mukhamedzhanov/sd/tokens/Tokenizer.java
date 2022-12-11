package am.s_mukhamedzhanov.sd.tokens;

import am.s_mukhamedzhanov.sd.states.EndState;
import am.s_mukhamedzhanov.sd.states.ErrorState;
import am.s_mukhamedzhanov.sd.states.State;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private String seq;
    private int curInd;

    public List<Token> parse(String seq) {
        this.seq = seq;
        var result = new ArrayList<Token>();

        curInd = 0;
        State curState = State.start();

        curState = curState.getNextState(this);

        while (!(curState instanceof ErrorState)
                && !(curState instanceof EndState)) {
            result.add(curState.createToken(this));
            while (!isEOF() && isWS()) {
                next();
            }
            curState = curState.getNextState(this);
        }

        if (curState instanceof ErrorState) {
            // todo
        }

        return result;
    }

    public boolean isNumber() {
        return Character.isDigit(getCurChar());
    }

    private boolean isWS() {
        return Character.isWhitespace(getCurChar());
    }

    public boolean isEOF() {
        return curInd >= seq.length();
    }

    public boolean isOpOrBr() {
        return "+-*/()".indexOf(getCurChar()) >= 0;
    }

    public char getCurChar() {
        return seq.charAt(curInd);
    }

    public void next() {
        curInd++;
    }

}
