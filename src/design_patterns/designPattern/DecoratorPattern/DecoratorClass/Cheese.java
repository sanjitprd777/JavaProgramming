package DecoratorPattern.DecoratorClass;

import DecoratorPattern.BaseClass.Pizza;

public class Cheese extends ToppingDecorator {
    Pizza pizza;
    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double cost() {
        return pizza.cost() + 20;
    }
}
