package LambdaExpression;

/*
Lambda Expression:
We can represent an Anonymous function.
Anonymous: Nameless/Unknown A method who doesn't have any name or modifier.

Syntax: Parameter  Expression  Body
        ()          ->          System.out.println("Lambda Syntax");

Note: If there is more than one statement in the body, use curly-braces {} to enclose the statements.
Only for the functional interfaces we can write the lambda expression for methods.
You may annotate the class with @FunctionalInterface to force it to have only one abstract method.
It can have many static or default methods.

Benefits:
- Helps to reduce boilerplate code.
- Reduce overall code.
 */

public class Demo {

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}
