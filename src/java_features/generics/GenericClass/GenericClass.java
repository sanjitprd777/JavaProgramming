package java_features.generics.GenericClass;

public class GenericClass {

    public static void main(String[] args) {
        GenericFactory<ABC> genericFactory = new GenericFactory<>(ABC.class);

        ABC abc = genericFactory.getInstance();
        System.out.println(abc.name);

        GenericFactory<DEF> genericFactory1 = new GenericFactory<>(DEF.class);
        DEF def = genericFactory1.getInstance();
        System.out.println(def.name);
    }
}
