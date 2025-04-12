package BridgePattern;

import BridgePattern.BreatheImplementor.LandBreatheImpl;
import BridgePattern.BreatheImplementor.TreeBreatheImpl;
import BridgePattern.LivingThings.Dog;
import BridgePattern.LivingThings.Tree;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree(new TreeBreatheImpl());
        tree.breatheProcess();

        Dog dog = new Dog(new LandBreatheImpl());
        dog.breatheProcess();
    }
}
