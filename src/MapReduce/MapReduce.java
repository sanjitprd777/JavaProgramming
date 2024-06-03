package MapReduce;

import java.util.Arrays;
import java.util.List;

public class MapReduce {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3,5,7,8,4,2,1,5,7);

        // Integer sum = numbers.stream().mapToInt(i->i).reduce(0, (a, b) -> a+b);
        // Get sum using method
        int sum = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum);

        Integer sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        // Multiply all value
        Integer multiplyValue = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(multiplyValue);

        // Get max value
        System.out.println(numbers.stream().reduce(0, (a, b) -> a>b?a:b));
        System.out.println(numbers.stream().reduce(0, Integer::max));


        // Find the longest string from a list of string
        List<String> stringList = Arrays.asList("fsjdk", "fkljdsfsk", "oirwejoriweoi");
        System.out.println(stringList.stream().reduce("", (a, b) -> a.length()>b.length()?a:b));
    }
}
