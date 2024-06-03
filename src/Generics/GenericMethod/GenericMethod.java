package Generics.GenericMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethod {

    static <T> T addAndReturn(T element, List<T> collector) {
        collector.add(element);
        return element;
    }

    static <T> T getInstance(Class<T> cls) {
        try {
            return (T) cls.newInstance();
        } catch (Exception ex) {}

        return null;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        addAndReturn("ab", strings);
        addAndReturn("cd", strings);
        addAndReturn("ef", strings);
        addAndReturn("gh", strings);

        for (String str : strings)
            System.out.println(str);
        System.out.println();

        List<Integer> integers = new ArrayList<>();
        addAndReturn(1, integers);
        addAndReturn(2, integers);
        System.out.println(integers);
        System.out.println();

        /*
        Note: The compiler can even perform more advanced type inference. For instance, the following call is also legal.

        In this case, we are using two different types for T: String and Object. The compiler then uses the most specific
        type argument that makes the method call type correct. In this case, it infers T to be Object.
         */
        String element = "String";
        List<Object> elements = new ArrayList<>();
        addAndReturn(element, elements);
        System.out.println(elements);

        /*
        The inverse is not legal though:
        In this case, the compiler infers, that for the method call to be type safe, T must be a String. The
        objectElement passed in for the T element parameter must then also be a String (and it isn't).
        Therefore, the compiler will report an error.

        Object ele = new Object();
        List<String> elements = new ArrayList<>();
        System.out.println(addAndReturn(ele, elements));
         */

        /*
        Class objects can be used as type specifications too, at runtime.
        For instance, you can create a generified method like this:
         */

        String str = getInstance(String.class);

        /*
        You can see, the return type changes depending on what class object you pass in as parameter to the method.
        This can be quite handy in database API like Butterfly Persistence where you read objects from a database.
        Here is an example method definition:

        public static <T> T read(Class<T> theClass, String sql)
            throws IllegalAccessException, InstantiationException {

            //execute SQL.

            T o = theClass.newInstance();
            //set properties via reflection.

            return o;
        }

        Here is how you would call the read() method:
        Driver employee = read(Driver.class, "select * from drivers where id=1");
        Vehicle vehicle = read(Vehicle.class, "select * from vehicles where id=1");
         */
    }
}
