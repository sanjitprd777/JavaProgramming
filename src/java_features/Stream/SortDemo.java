package java_features.Stream;

import java_features.LambdaExpression.Example.Book;
import java_features.LambdaExpression.Example.BookDAO;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,3,2,1);
        // Traditional method to sort
        Collections.sort(list); // Ascending
        System.out.println(list);
        Collections.reverse(list); // Descending
        System.out.println(list);

        // Using lambda method
        list.stream().sorted().forEach(System.out::print); // Ascending
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print); // Descending
        System.out.println();

        // Sort custom object
        List<Book> books = new BookDAO().books;
        books.add(new Book(1, "wq"));
        books.add(new Book(2, "fas"));
        books.add(new Book(3, "are"));
        books.add(new Book(4, "ngr"));
        books.add(new Book(4, "ve"));
        books.add(new Book(4, "ef"));

        // Traditional sorting way
        books.sort(MyComparator.getInstance());
        Collections.sort(books, MyComparator.getInstance());
        System.out.println(books);

        // Traditional method again
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.name.compareTo(o1.name);
            }
        });
        System.out.println(books);

        // Using lambda expression
        Collections.sort(books, (o1, o2) -> o2.id - o1.id);
        System.out.println(books);

        // Using Stream API
        books.stream().sorted((o1, o2) -> o1.id - o2.id).forEach(System.out::print);
        System.out.println();

        // Another way
        books.stream().sorted(Comparator.comparing(book -> book.id)).forEach(System.out::print);
        System.out.println();

    }

}


// Making it Singleton so that we don't need to create new instance everytime.
class MyComparator implements Comparator<Book> {

    private static MyComparator myComparator;
    private MyComparator() {
        System.out.println(this);
    }

    public static MyComparator getInstance() {
        if (myComparator == null) {
            myComparator = new MyComparator();
        }
        return myComparator;
    }

    @Override
    public int compare(Book o1, Book o2) {
        return o1.name.compareTo(o2.name);
    }
}