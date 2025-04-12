package StatePattern.state;

import StatePattern.Driver;

public class Start implements State {

    Driver driver;
    public Start(Driver driver) {
        this.driver = driver;
    }

    public String toString() {
        return "State of the program is 'Start'";
    }

    @Override
    public void startProgram() {
        System.out.println("Starting the Program");
        this.driver.setState(new End(driver));
    }

    @Override
    public void endGame() {

    }
}
