package MapANDflatMap;

import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

    public static void main(String[] args) {

        List<Customer> customers = EkartDataBase.getAll();

        // Get emails from all customers: Data Transformation
        // Mapping logic: customer -> customer.getEmail() OR Customer::getEmail
        // This is one to one mapping (why?) Bcz one customer has one email id.
        List<String> emails = customers.stream().map(Customer::getEmail).collect(Collectors.toList());
        System.out.println(emails);

        // Get a phone numbers list from all customers.
        // Mapping logic: customer -> customer.getPhoneNumbers()
        // This is one to many mapping (why?) Bcz one customer has multiple phone numbers.
        List<List<String>> phoneNumbers = customers.stream().map(Customer::getPhoneNumbers).collect(Collectors.toList());
        System.out.println(phoneNumbers);

        // Fix using 'flatMap'
        List<String> phoneNumbersFlatted = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println(phoneNumbersFlatted);
    }
}
