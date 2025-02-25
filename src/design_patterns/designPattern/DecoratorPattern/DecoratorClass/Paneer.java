package DecoratorPattern.DecoratorClass;

import DecoratorPattern.BaseClass.Pizza;

public class Paneer extends ToppingDecorator {
    Pizza pizza;

    public Paneer(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public double cost() {
        return pizza.cost() + 50;
    }
}
