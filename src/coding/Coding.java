package coding;

import java.util.*;

public class Coding {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(100);
        System.out.println(hs.add(2));
        System.out.println(hs.add(2));
        hs.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
    }
}

