package FunctionalInterface.SupplierFunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//public class SupplierDemo implements Supplier<String> {
//    @Override
//    public String get() {
//        return "Hi Sanjit";
//    }
//
//    public static void main(String[] args) {
//        Supplier<String> supplier = new SupplierDemo();
//        System.out.println(supplier.get());
//    }
//}

public class SupplierDemo {
    public static void main(String[] args) {

        Supplier<String> supplier = () ->  "Hi Sanjit";
        System.out.println(supplier.get());

        System.out.println();
        List<String> list = Arrays.asList("a", "b");
        System.out.println(list.stream().findAny().orElseGet(() -> "Hi Sanjit"));


        System.out.println();
        List<String> list1 = List.of();
        System.out.println(list1.stream().findAny().orElse("Hi Sanjit"));
    }
}
