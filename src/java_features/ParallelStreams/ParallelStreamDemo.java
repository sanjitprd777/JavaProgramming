package java_features.ParallelStreams;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamDemo {

    public static void main(String[] args) {

        long start = 0;
        long end = 0;

        start = System.currentTimeMillis();
        IntStream.range(1, 1000).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Plain stream time taken: " + (end - start));

        System.out.println("#################################################");
        start = System.currentTimeMillis();
        IntStream.range(1, 1000).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Parallel stream time taken: " + (end - start));

        System.out.println("#################################################");
        IntStream.range(1, 10).forEach(x -> {
            System.out.println(x + " : " + "Plain Thread name: " + Thread.currentThread());
        });

        System.out.println("#################################################");
        IntStream.range(1, 10).parallel().forEach(x -> {
            System.out.println(x + " : " + "Parallel Thread name: " + Thread.currentThread());
        });

        System.out.println("#################################################");
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallelStream().forEach(x -> {
            System.out.println(x + " : " + "Parallel Thread name: " + Thread.currentThread());
        });
    }
}
