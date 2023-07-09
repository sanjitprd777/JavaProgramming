package LambdaExpression;

@FunctionalInterface
public interface MyFunctionalInterface {
    public abstract void m1();

    static void m2() {
        System.out.println("I'm static");
    }

    default void m3() {
        System.out.println("I'm default");
    }
}
