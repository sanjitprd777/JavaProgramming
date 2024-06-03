package Generics.GenericWildcard;

import java.util.ArrayList;
import java.util.List;

public class SuperWildcard {

    /*
List<? super A> means that the list is typed to either the A class, or a superclass of A.

When you know that the list is typed to either A, or a superclass of A, it is safe to insert instances of A or
subclasses of A (e.g., B or C) into the list. Here is an example:

public static void insertElements(List<? super A> list) {
    list.add(new A());
    list.add(new B());
    list.add(new C());
}
All of the elements inserted here are either A instances, or instances of A's superclass.
Since both B and C extend A, if A had a superclass, B and C would also be instances of that superclass.

You can now call insertElements() with either a List<A>, or a List typed to a superclass of A.
Thus, this example is now valid:

List<A>      listA      = new ArrayList<A>();
insertElements(listA);

List<Object> listObject = new ArrayList<Object>();
insertElements(listObject);

The insertElements() method cannot read from the list though, except if it casts the read objects to Object.
The elements already present in the list when insertElements() is called could be of any type that is either an A
or superclass of A, but it is not possible to know exactly which class it is. However, since any class eventually
subclass Object, you can read objects from the list if you cast them to Object. Thus, this is valid:

Object object = list.get(0);
But this is not valid:
A object = list.get(0);
     */

    static void insertAndPrintElement(List<? super Number> numbers) {

        // We can add elements class Number or its subclass or superclass.
        numbers.add(3);
        numbers.add(3.33333);

        for (Object o : numbers)
            System.out.print(o + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2.222);
        insertAndPrintElement(numbers);

        List<Object> objects = new ArrayList<>();
        objects.add(55);
        insertAndPrintElement(objects);
    }
}
