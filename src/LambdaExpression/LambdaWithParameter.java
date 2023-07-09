package LambdaExpression;

interface SumTotal {

    void sum(int input);

}
public class LambdaWithParameter {

    public static void main(String[] args) {
        SumTotal cal = (x) -> System.out.println("Sum: " + x);
        cal.sum(5);
    }
}
