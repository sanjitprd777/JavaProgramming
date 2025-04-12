package StatePattern;

public class Main {

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.printState();

        driver.state.startProgram();

        driver.printState();

        driver.state.endGame();
    }
}
