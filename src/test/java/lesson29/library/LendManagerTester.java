package lesson29.library;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.mockito.internal.verification.NoMoreInteractions;

import static org.mockito.Mockito.*;

public class LendManagerTester {

    @Test
    public void normalCheckoutTest() {
        // создадим мок для класса
        BookService service = Mockito.mock(BookService.class);

        // книжка с ид 100 доступна для выдачи
        when(service.inStock(100)).thenReturn(true);

        BookLendManager manager = new BookLendManager(service);

        //пытаемся выдать книгу с ид 100 пользователю с ид 300
        manager.checkout(100, 300);

        // проверки что функции мока вызывались с нужными параметрами

        verify(service).inStock(100);
        verify(service).lend(100, 300);

        // как минимум один раз вызывалась функция (anyInt - любое целое если значение на важно)
        verify(service, atLeast(1)).inStock(anyInt());

        // и больше никаких взаимодействий с моком не было

        verifyNoInteractions(service);
        // как минимум один раз вызывалась функция (anyInt - любое целое если значение на важно)
        verify(service, atLeast(1)).inStock(anyInt());
        // функция вызывалась максимум 10 раз
        verify(service, atMost(10)).lend(100, 300);

    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void bookIsNotAvailableTest()
    {
        // напишите код который проверит что вылетело нужное исключение
        // с нужным сообщением
        // до 21:38
        exception.expectMessage(String.valueOf(IllegalStateException.class));
        exception.expectMessage("Book is not available");

        // создадим мок для класса
        BookService service = Mockito.mock(BookService.class);
        // программируем поведение мока -
        // книжка с ид 100 - НЕ доступна для выдачи
        when(service.inStock(100)).thenReturn(false);

        BookLendManager manager = new BookLendManager(service);
        // пытаемся выдать книгу с ид 100 пользователю с ид 300
        manager.checkout(100, 300);

        verify(service, times(1)).inStock(100);
        verify(service, never()).lend(anyInt(), anyInt());
        verifyNoMoreInteractions(service);

    }
}
