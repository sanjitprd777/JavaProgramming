package Generics.GenericWildcard;

import java.util.List;

public class UnknownWildcard {

    /*
List<?> means a list typed to an unknown type. This could be a List<A>, a List<B>, a List<String> etc.

Since you do not know what type the List is typed to, you can only read from the collection, and you can only treat the
objects read as being Object instances. Here is an example:

public void processElements(List<?> elements){
   for(Object o : elements){
      System.out.println(o);
   }
}

The processElements() method can now be called with any generic List as parameter.
For instance, a List<A>, a List<B>, List<C>, a List<String> etc. Here is a valid example:

List<A> listA = new ArrayList<A>();
processElements(listA);
     */

    static void printElement(List<?> list) {
        for (Object o : list)
            System.out.print(o + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9);
        printElement(integerList);

        List<String> stringList = List.of("abc", "def", "ghi");
        printElement(stringList);
    }
}
