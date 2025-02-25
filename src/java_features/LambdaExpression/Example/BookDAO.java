package java_features.LambdaExpression.Example;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<Book> books;

    public BookDAO() {
        books = new ArrayList<>();
        books.add(new Book(1, "a"));
        books.add(new Book(2, "b"));
        books.add(new Book(3, "c"));
        books.add(new Book(4, "d"));
        books.add(new Book(5, "e"));
        books.add(new Book(6, "f"));
    }
}
