package design_patterns.CreationalDesignPatterns.Factory.ExampleUsingIfElse;

import design_patterns.CreationalDesignPatterns.Factory.ExampleUsingIfElse.Factory.ShapeCreator;
import design_patterns.CreationalDesignPatterns.Factory.ExampleUsingIfElse.Factory.ShapeFactory;

public class Demo {

    public static void main(String ...args) {
        ShapeCreator shapeCreator = new ShapeCreator(new ShapeFactory());
        shapeCreator.getShape("Circle");
        shapeCreator.getShape("Square");
    }
}
