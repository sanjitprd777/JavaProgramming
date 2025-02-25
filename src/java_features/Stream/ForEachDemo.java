package java_features.Stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        // Traditional method
        for (String s: list) {
            System.out.println(s);
        }
        System.out.println();

        // Using stream API
        list.stream().forEach(System.out::println);
        System.out.println();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        // Traditional method
        map.entrySet().stream().forEach(obj -> System.out.println(obj.getKey() + " = " + obj.getValue()));
        System.out.println();

        // Stream API
        map.forEach((key, value) -> System.out.println(key + " = " + value));
        System.out.println();

        // Consumer functional interface
        Consumer<String> consumer = (t) -> System.out.println(t);
        consumer.accept("Hi Sanjit");
        System.out.println();

        for (String s:list) {
            consumer.accept(s);
        }
    }
}
