package java_features.MapANDflatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDataBase {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("4234324123", "532523452")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("885787", "63453465")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("95768456", "5124524543")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("14235565", "975475524")),
                new Customer(105, "alpha", "aplha@gmail.com", Arrays.asList("86758563635", "4365485658"))
        ).collect(Collectors.toList());
    }
}
