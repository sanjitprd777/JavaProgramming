package java_features.Stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        // Traditional method
        for (String s:list) {
            if (s.startsWith("c")) {
                System.out.println(s);
            }
        }
        System.out.println();

        // Stream + Lambda expression
        list.stream().filter(s -> s.startsWith("c")).forEach(System.out::println);
        System.out.println();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        map.entrySet().stream().filter(k -> k.getKey()%2==0).forEach(System.out::println);
    }
}
