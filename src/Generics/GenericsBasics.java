package Generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericsBasics {

    /*
    Java Generics enable us to gain type safety in situations where classes and methods that are designed to be able to
    work with any type would otherwise be designed to work with Object instances. For instance, without Java Generics,
    the Java List, Java Set, Java Map, etc. interfaces would all be working on Object instances. With Java Generics,
    you can create List, Set or Map instances that work on specific types, e.g., a List of Strings, rather than a List
    of Objects, so you achieve higher type safety in your code.

    Java Generics add type parameters to classes, interfaces, methods and variables that decide to use them. To be able
    to use a type parameter with a class, interface, method or variable the type you are trying to add the type
    parameter to, must be designed to allow generic type parameters.

    */

    public static void main(String[] args) {

        /*
        Previously, the Collections such as List, Set, etc. works with Object a type. Hence, we can put any object type in
        a list. But to dereference the list, we need to typecast the returned object to a specific type.
        Example:
         */
        List list = new ArrayList();
        list.add(new Integer[]{3});
        list.add(new String("abc"));
        Integer[] ii = (Integer[]) list.get(0);
        String ss = (String) list.get(1);
        System.out.println(ii[0]);
        System.out.println(ss);
        System.out.println();
        /*
        New Implementation: From Java 7, we can now provide the type to list (Collection) so that list will contain
        elements of only specific types.
         */

        List<String> list1 = new ArrayList<>();
        list1.add(new String("abc"));
        list1.add(new String("def"));
        list1.add("ghi");
        for (String s : list1)
            System.out.println(s);
        System.out.println();
        /*
        But how does java know about the type of element the collection can store?

        The Java generics features were updated in Java 7. From Java 7, the Java compiler can infer the type of the
        collection instantiated from the variable the collection is assigned to
         */

        List<String> strings = new ArrayList<>();
        /*
        Notice how the generic type of the ArrayList has been left out. Instead, is only the <> written. This is also
        sometimes referred to as the diamond operator. When you just write a diamond operator as a generic type,
        the Java compiler will assume that the class instantiated is to have the same type as the variable it is
        assigned to. In the example above, that means String because the List variable has a String set as its type.
         */

        /*
        Iterate Generic collections.

        Earlier we used iterator to iterate collections using hasNext() and next() functions in a while loop.
         */
        Iterator<String> stringIterator = list1.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
        System.out.println();

        /*
        But from Java 5, a new for-each loop is introduced which can infer the type of element from collection using variable.
         */
        for (String str : list1)
            System.out.println(str);
    }
}
