package FunctionalInterface.PredicateFunctonalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//public class PredicateDemo implements Predicate<Integer> {
//    @Override
//    public boolean test(Integer integer) {
//        return integer%2==0;
//    }
//
//    public static void main(String[] args) {
//        Predicate<Integer> predicate = new PredicateDemo();
//        System.out.println(predicate.test(5));
//        System.out.println(predicate.test(6));
//    }
//}

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate = integer -> integer%2==0;
        System.out.println(predicate.test(5));
        System.out.println(predicate.test(6));
        System.out.println();

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().filter(t -> t%2==0).forEach(System.out::println);
    }
}