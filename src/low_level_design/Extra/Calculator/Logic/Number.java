package Calculator.Logic;

public class Number implements Value {

    double number;

    public Number(double number) {
        this.number = number;
    }

    @Override
    public double evaluate() {
        return number;
    }
}
