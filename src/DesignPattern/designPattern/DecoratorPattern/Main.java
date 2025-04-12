package DecoratorPattern;

import DecoratorPattern.BaseClass.Margherita;
import DecoratorPattern.BaseClass.Pizza;
import DecoratorPattern.DecoratorClass.Cheese;
import DecoratorPattern.DecoratorClass.Paneer;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Margherita();
        System.out.println("The cost of your pizza is " + pizza.cost());
        // Add extra cheese and paneer to it.
        pizza = new Paneer(new Cheese(pizza));
        System.out.println("The cost after adding toppings is " + pizza.cost());
    }
}
