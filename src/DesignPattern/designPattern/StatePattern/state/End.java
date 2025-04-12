package StatePattern.state;

import StatePattern.Driver;

public class End implements State {
    Driver driver;

    public End(Driver driver) {
        this.driver = driver;
    }

    public String toString() {
        return "State of the program is 'End'";
    }


    @Override
    public void startProgram() {

    }

    @Override
    public void endGame() {
        System.out.println("Ending the program");
    }
}
