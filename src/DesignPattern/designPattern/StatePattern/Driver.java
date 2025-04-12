package StatePattern;

import StatePattern.state.Start;
import StatePattern.state.State;

public class Driver {

    State state;

    Driver() {
        state = new Start(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    void printState() {
        System.out.println(this.state.toString());
    }
}
