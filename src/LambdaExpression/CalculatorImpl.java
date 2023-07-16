package LambdaExpression;

interface Calculator {
    void switchOn();
}

// How to write lambda expression. The syntax is: parameter (), Expression ->, And method body {}

// Traditional method without lambda expression.
// public class CalculatorImpl implements Calculator {
//
//    @Override
//    public void switchOn() {
//
//    }
// }


// Using lambda expression. Also assign the lambda expression to the corresponding interface 'Calculator'
public class CalculatorImpl {
    public static void main(String[] args) {

        Calculator cal = () -> {
            System.out.println("Switch On");
        };

        // Note: If there is only one line code/statement, then you don't need to add {}.
        Calculator cal2 = () -> System.out.println("Switch On");

        cal.switchOn();
        cal2.switchOn();
    }
}