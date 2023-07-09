package LambdaExpression;

interface LambdaReturn {
    int method(int x, int y);
}

public class LambdaWithReturn {

    public static void main(String[] args) {
        LambdaReturn lambdaReturn = (x, y) -> x+y;
        // Also using method reference:
        //        LambdaReturn lambdaReturn = Integer::sum;
        System.out.println(lambdaReturn.method(3,9));


        LambdaReturn lambdaReturn1 = (x, y) -> {
            if (x>1) {
                x = x+100;
            }
            return x+y;
        };
        lambdaReturn1.method(1,2);
        lambdaReturn1.method(2,2);
    }
}
