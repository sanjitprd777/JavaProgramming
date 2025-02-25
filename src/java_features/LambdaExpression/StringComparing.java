package java_features.LambdaExpression;

import java.util.Comparator;

public class StringComparing {
    static String staticText = "PQRST";

    interface MyFunction1 {
        public void apply();
    }

    interface MyFunction2 {
        public void apply(String str);
    }

    interface MyFunction3 {
        public void apply(String str1, String str2);
    }

    public static void main(String[] args) {
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(stringComparator.compare("hello", "world"));

        Comparator<String> stringComparatorLambda = (o1, o2) -> o1.compareTo(o2);
        System.out.println(stringComparatorLambda.compare("hello", "world"));

        MyFunction1 function1 = () -> System.out.println("No input");
        function1.apply();

        MyFunction2 function2 = text -> System.out.println("Input: " + text);
        function2.apply("ABC");

        MyFunction3 function3 = (text1, text2) -> System.out.println(text1 + " " + text2);
        function3.apply("ABC", "DEF");

        // Note: Java lambda expressions are object just like anonymous implementation of interface.
        MyFunction3 function3_1 = function3;
        function3_1.apply("ABC", "DEF");

        // Note: Java lambda expression can only implement functional interfaces is not truly correct.
        // Because it can contain as many default and static methods.
        // However, the interface can only have one single non-implemented method i:e abstract method.

        // Lambda expressions are stateless, i:e they do not have any member variables like other classes have.
        // If they want to access any variable outside its definition, then it must be declared final.
        final String otherText = "ABCDE";

        MyFunction2 function2_1 = text -> System.out.println(otherText + " : " + text);

        function2_1.apply("WORLD");

        // If I do below it will then function2_1 will fail bcz, otherText should be final.
//        otherText = "FKJDSFDLK"; -> Wrong, cannot do it.

        // Note: Above rule only applies for local variable defined inside the same method.
        // For class instance variables and static variables, we can change them anywhere.

        staticText = "Updated text";
        function2_1.apply(staticText);

    }
}
