package books.bookoperations;

import books.Book;

public interface BookOperations {

    void insertBook(Book b);

    Book getBook(int bookId);

    void showAllBooks();

}