package java_features.generics.GenericWildcard;

public class Basics {

    /*
    Imagine you have the following class hierarchy:

    public class A { }
    public class B extends A { }
    public class C extends A { }
    The classes B and C both inherit from A.

    Then look at these two List variables:

    List<A> listA = new ArrayList<A>();
    List<B> listB = new ArrayList<B>();
    Can you set listA to point to listB ? or set listB to point to listA? In other words, are these assignments valid:

    listA = listB;

    listB = listA;
    The answer is no in both cases. Here is why:

    In listA you can insert objects that are either instances of A, or subclasses of A (B and C). If you could do this:

    List<B> listB = listA;
    then you could risk that listA contains non-B objects. When you then try to take objects out of listB, you could
    risk getting non-B objects out (e.g., an A or a C). That breaks the contract of the listB variable declaration.

    Assigning listB to listA also poses a problem. This assignment, more specifically:

    listA = listB;
    If you could make this assignment, it would be possible to insert A and C instances into the List<B> pointed to by
    listB. You could do that via the listA reference, which is declared to be of List<A>. Thus, you could insert non-B
    objects into a list declared to hold B (or B subclass) instances.

================

    The generic wildcard operator is a solution to the problem explained above. The generic wildcards target two primary needs:

    Reading from a generic collection.
    Inserting into a generic collection.
    There are three ways to define a collection (variable) using generic wildcards. These are:

    List<?>           listUknown = new ArrayList<A>();
    List<? extends A> listUknown = new ArrayList<A>();
    List<? super   A> listUknown = new ArrayList<A>();

     */

    public static void main(String[] args) {



    }
}
