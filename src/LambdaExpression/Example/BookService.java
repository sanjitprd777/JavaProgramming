package LambdaExpression.Example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {

    // Traditional way to sort the bookList using Comparator class.
    public List<Book> getBooksInSort() {
        List<Book> bookList = new BookDAO().books;
        Collections.sort(bookList, new MyComparator());
//        bookList.sort(new MyComparator());
        return bookList;
    }

    // Lambda expression way to sort bookList
    public List<Book> getBooksInSortUsingLambda() {
        List<Book> bookList = new BookDAO().books;
//        Collections.sort(bookList, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o2.name.compareTo(o1.name);
//            }
//        });
//
        Collections.sort(bookList, (o1, o2) -> o2.name.compareTo(o1.name));
        // bookList.sort((o1, o2) -> o2.name.compareTo(o1.name));
        return bookList;
    }

    public static void main(String[] args) {
        System.out.println(new BookService().getBooksInSort());
        System.out.println();
        System.out.println(new BookService().getBooksInSortUsingLambda());
    }
}

class MyComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o2.name.compareTo(o1.name);
    }
}