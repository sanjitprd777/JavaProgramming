package Calculator;

import Calculator.Logic.Expression;
import Calculator.Logic.Number;
import Calculator.Logic.Operation;

public class Main {

    public static void main(String[] args) {

        Number number = new Number(5);
        Number number1 = new Number(2);
        Number number2 = new Number(3);
        Number number3 = new Number(9);

        Operation operation1 = new Operation(Expression.ADD, number, number1);
        Operation operation2 = new Operation(Expression.MULTIPLY, number2, number3);
        Operation operation = new Operation(Expression.MULTIPLY, operation1, operation2);
        System.out.println(operation.evaluate());
    }
}
