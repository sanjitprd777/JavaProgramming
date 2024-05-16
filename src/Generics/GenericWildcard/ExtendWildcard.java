package Generics.GenericWildcard;

import java.util.List;

public class ExtendWildcard {

    /*
List<? extends A> means a List of objects that are instances of the class A, or subclasses of A (e.g., B and C).

When you know that the instances in the collection are of instances of A or subclasses of A, it is safe to read the
instances of the collection and cast them to A instances. Here is an example:

public void processElements(List<? extends A> elements){
   for(A a : elements){
      System.out.println(a.getValue());
   }
}
You can now call the processElements() method with either a List<A>, List<B> or List<C>.
Hence, all of these examples are valid:

List<A> listA = new ArrayList<A>();
processElements(listA);

List<B> listB = new ArrayList<B>();
processElements(listB);

List<C> listC = new ArrayList<C>();
processElements(listC);
The processElements() method still cannot insert elements into the list, because you don't know if the list passed as
parameter is typed to the class A, B or C.
     */

    static void printElement(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1,2,3,4,5,6);
        printElement(integers);

        List<Double> doubles = List.of(1.1, 2.0, 3.33333, 4.5678);
        printElement(doubles);

        List<Number> numbers = List.of(1, 2.2, 3.33333, 4, 5555);
        printElement(numbers);
    }
}
