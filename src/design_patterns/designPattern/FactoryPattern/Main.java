package FactoryPattern;

import FactoryPattern.Shape.ShapeFactory;
import FactoryPattern.Shape.shape;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shape circle = shapeFactory.getShape("Circle");
        circle.draw();

        shape rectangle = shapeFactory.getShape("Rectangle");
        rectangle.draw();
    }
}
