package DecoratorPattern.DecoratorClass;

import DecoratorPattern.BaseClass.Pizza;

public class Mushroom extends ToppingDecorator {
    Pizza pizza;

    public Mushroom(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public double cost() {
        return pizza.cost() + 10;
    }
}
