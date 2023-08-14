package lesson29.library;

public class BookLendManager {
    private BookService service;

    public BookLendManager(BookService service) {
        this.service = service;
    }

    // будем тестировать выдачу книги определенному пользователю
    public void checkout(int bookId, int memberId) {
        if (service.isStock(bookId)) {
            service.lend(bookId, memberId);
        } else {
            throw new IllegalStateException("Book is not available!");
        }
    }
}

interface BookService {
    // доступна ли книга для выдачи
    boolean isStock(int bookId);

    // выдаем книгу пользователю
    void lend(int bookId, int memberId);
}
