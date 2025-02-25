package java_features.Stream;

import java_features.LambdaExpression.Example.Book;

import java.util.*;

public class SortMapDemo {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("eight", 8);
        map.put("one", 1);
        map.put("four", 4);
        map.put("nine", 9);
        map.put("two", 2);

        // Traditional sorting method
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        System.out.println(entries);

        // Using lambda expression
        Collections.sort(entries, (o1, o2) -> o2.getKey().compareTo(o1.getKey()));
        System.out.println(entries);

        // Using stream expression
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::print);
        System.out.println();

        // Using stream expression
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::print);
        System.out.println();

        // Using stream expression
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(String::compareTo)).forEach(System.out::print);
        System.out.println();

        // Using stream + lambda expression
        map.entrySet().stream().sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey())).forEach(System.out::print);
        System.out.println();

        // Custom object sorting in a map
        Map<Book, Integer> bookMap = new TreeMap<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        bookMap.put(new Book(1, "a"), 33);
        bookMap.put(new Book(5, "agsf"), 33);
        bookMap.put(new Book(324, "qwea"), 33);
        bookMap.put(new Book(56, "hdfa"), 678);
        bookMap.put(new Book(12, "q345a"), 42333);
        bookMap.put(new Book(9561, "12a"), 3);
        bookMap.put(new Book(5341, "u43a"), 3233);
        System.out.println(bookMap);

        Map<Book, Integer> bookMap1 = new TreeMap<>((o1,  o2) -> o2.name.compareTo(o1.name));
        bookMap1.put(new Book(1, "a"), 33);
        bookMap1.put(new Book(5, "agsf"), 33);
        bookMap1.put(new Book(324, "qwea"), 33);
        bookMap1.put(new Book(56, "hdfa"), 678);
        bookMap1.put(new Book(12, "q345a"), 42333);
        bookMap1.put(new Book(9561, "12a"), 3);
        bookMap1.put(new Book(5341, "u43a"), 3233);
        System.out.println(bookMap1);

    }
}
