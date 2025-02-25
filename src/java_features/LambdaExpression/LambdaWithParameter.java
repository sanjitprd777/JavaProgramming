package java_features.LambdaExpression;

interface SumTotal {

    void sum(int input);

}
public class LambdaWithParameter {

    public static void main(String[] args) {
//        SumTotal cal = (x) -> System.out.println("Sum: " + x);
//        If there is one parameter, then no need to add parenthesis.

        SumTotal cal = x -> System.out.println("Sum: " + x);
        cal.sum(5);
    }
}
