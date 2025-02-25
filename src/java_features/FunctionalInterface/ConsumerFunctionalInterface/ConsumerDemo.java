package java_features.FunctionalInterface.ConsumerFunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        // Using Lambda expression for Consumer interface
        Consumer<Integer> consumer = i -> System.out.println("Args: " + (i+100));
        consumer.accept(5);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().forEach(val -> System.out.println("Value: " + val));
//        list.forEach(consumer);
    }
}
