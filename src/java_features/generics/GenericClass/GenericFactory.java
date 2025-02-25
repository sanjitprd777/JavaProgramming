package java_features.generics.GenericClass;

public class GenericFactory<T> {
    Class theClass = null;

    public GenericFactory(Class c) {
        this.theClass = c;
    }

    public T getInstance() {
        try {
            return (T) this.theClass.newInstance();
        } catch (Exception ex) {}
        return null;
    }
}