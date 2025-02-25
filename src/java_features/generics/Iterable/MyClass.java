package java_features.generics.Iterable;

import java.util.Iterator;

public class MyClass<E> implements Iterable<E> {

    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }
}
