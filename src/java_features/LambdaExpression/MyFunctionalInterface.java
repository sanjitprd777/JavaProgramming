package java_features.LambdaExpression;

@FunctionalInterface
public interface MyFunctionalInterface {
    // All interface methods are by default public and abstract (non static and non default).
    void m1();

    static void m2() {
        System.out.println("I'm static");
    }

    default void m3() {
        System.out.println("I'm default");
    }
}
