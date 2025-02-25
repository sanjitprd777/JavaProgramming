package FactoryPattern.Shape;

public class ShapeFactory {

    public shape getShape(String input) {
        switch(input) {
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            default:
                return null;
        }
    }
}
