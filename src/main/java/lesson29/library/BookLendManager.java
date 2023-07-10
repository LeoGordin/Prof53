package lesson29.library;

public class BookLendManager {
    private BookService service;

    public BookLendManager(BookService service) {
        this.service = service;
    }

    // будем тестировать выдачу книги определенному пользователю
    public void checkout(int bookId, int memberId) {
        if (service.inStock(bookId)) {
            service.lend(bookId, memberId);
        } else {
            throw new IllegalStateException("Book is not available!");
        }
    }
}

interface BookService {
    boolean inStock(int bookId);  // доступна ли книга для выдачи
    void lend(int bookId, int memberId);    // выдаем книгу пользователю
}
