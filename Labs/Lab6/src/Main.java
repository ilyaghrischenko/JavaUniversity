import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Додати книги до бібліотеки
        library.addBook(new Book("Book 1", 2006));
        library.addBook(new Book("Book 2", 2010));
        library.addBook(new Book("Book 3", 1995));

        // Отримати список книг, які вийшли після 2005 року
        List<Book> booksPublishedAfter2005 = library.getBooksPublishedAfter(2005);

        // Вивести список книг
        for (Book book : booksPublishedAfter2005) {
            System.out.println(book.getTitle() + " (" + book.getYear() + ")");
        }
    }
}