package design_patterns.CreationalDesignPatterns.Factory.ExampleUsingIfElse.Factory;

import design_patterns.CreationalDesignPatterns.Factory.ExampleUsingIfElse.Products.Circle;
import design_patterns.CreationalDesignPatterns.Factory.ExampleUsingIfElse.Products.Shape;
import design_patterns.CreationalDesignPatterns.Factory.ExampleUsingIfElse.Products.Square;

public class ShapeFactory {

    public Shape getShapeProduct(String input) {
        /*
        When you have code that makes use of lots of concrete classes, you’re looking for trouble because that
        code may have to be changed as new concrete classes are added. So, in other words, your code will not be
        “closed for modification.” To extend your code with new concrete types, you'll have to reopen it.
         */
        return switch (input) {
            case "Circle" -> new Circle();
            case "Square" -> new Square();
            default -> null;
        };
    }
}
