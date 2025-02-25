package java_features.Optional;

import java_features.MapANDflatMap.Customer;

import java.util.Arrays;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Customer customer = new Customer(1, "a", "fjslkdfjslk", Arrays.asList("32", "543"));

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        // Use Optional.of() if we know the object is never null as it does check for that internally.
//        Optional<String> emailOptional = Optional.of(customer.getEmail());
//        System.out.println(emailOptional);

        // Use Optional.ofNullable when we know that object could be either null or not null.
        // If the value is present, it does Optional.of check otherwise returns Optional.empty;
        Optional<String> emailOptionalNull = Optional.ofNullable(customer.getEmail());
        // Check if any value is present or not.
        emailOptionalNull.ifPresent(System.out::println);

        // Either return actual value is present or default value.
        System.out.println(emailOptionalNull.orElse("default@email.com"));

        // Throw exception
        System.out.println(emailOptionalNull.orElseThrow(() -> new IllegalArgumentException("Email not present")));

        /*
         * One best practice in programming
         * Instead of writing -> String getEmail() {return email};
         * We can write -> Optional<String> getEmail() {return Optional.ofNullable(email)};
         */
    }
}
