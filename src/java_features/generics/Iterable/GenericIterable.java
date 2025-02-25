package java_features.generics.Iterable;

public class GenericIterable {
    /*
    It is possible to use your own collection type classes with the new for-loop. To do so, your class must implement
    the java.lang.Iterable<E> interface. Here is a very basic example:

    public class MyCollection<E> implements Iterable<E>{

        public Iterator<E> iterator() {
            return new MyIterator<E>();
        }
    }

    And here is the corresponding implementation skeleton of the MyIterator class:

    public class MyIterator <T> implements Iterator<T> {

        public boolean hasNext() {

            //implement...
        }

        public T next() {
            //implement...;
        }

        public void remove() {
            //implement... if supported.
        }
    }
    Here is how to use the MyCollection generified, and with the new for-loop:

    public static void main(String[] args) {
        MyCollection<String> stringCollection = new MyCollection<String>();

        for(String string : stringCollection){

        }
    }
     */

    public static void main(String[] args) {
        MyClass<String> myClass = new MyClass<String>();

        for (String str : myClass) {
            System.out.println(str);
        }
    }
}
