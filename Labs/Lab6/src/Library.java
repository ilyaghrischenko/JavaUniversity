import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Додати книгу до бібліотеки
    public void addBook(Book book) {
        books.add(book);
    }

    // Отримати список книг, які вийшли після заданого року
    public List<Book> getBooksPublishedAfter(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isPublishedAfter(year)) {
                result.add(book);
            }
        }
        return result;
    }
}