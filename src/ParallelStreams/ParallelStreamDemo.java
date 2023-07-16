package ParallelStreams;

import java.util.stream.IntStream;

public class ParallelStreamDemo {

    public static void main(String[] args) {

        long start=0;
        long end=0;

        start = System.currentTimeMillis();
        IntStream.range(1,100).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Plain stream time taken: " + (end-start));


        start = System.currentTimeMillis();
        IntStream.range(1,100).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Parallel stream time taken: " + (end-start));

        IntStream.range(1,10).forEach(x -> {
            System.out.println("Plain Thread name" + Thread.currentThread());
        });

        IntStream.range(1,10).parallel().forEach(x -> {
            System.out.println("Parallel Thread name" + Thread.currentThread());
        });
    }
}
