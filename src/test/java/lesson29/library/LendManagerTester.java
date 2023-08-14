package lesson29.library;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class LendManagerTester {

    @Test
    public void normalCheckoutTest()
    {
        // создадим мок для класса
        BookService service = Mockito.mock(BookService.class);
        // программируем поведение мока -
        // книжка с ид 100 - доступна для выдачи
        when(service.isStock(100)).thenReturn(true);

        BookLendManager manager = new BookLendManager(service);
        // пытаемся выдать книгу с ид 100 пользователю с ид 300
        manager.checkout(100, 300);

        // проверки что функции мока вызывались с нужными параметрами
        verify(service).isStock(100);
        verify(service).lend(100, 300);

        // как минимум один раз вызывалась функция (anyInt - любое целое если значение на важно)
        verify(service, atLeast(1)).isStock(anyInt());

        // функция вызывалась максимум 10 раз
        verify(service, atMost(10)).lend(100, 300);

        // и больше никаких взаимодействий с моком не было
        verifyNoMoreInteractions(service);
    }


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void bookIsNotAvailableTest()
    {
        // напишите код который проверит что вылетело нужное исключение
        // с нужным сообщением
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Book is not available!");

        // создадим мок для класса
        BookService service = Mockito.mock(BookService.class);
        // программируем поведение мока -
        // книжка с ид 100 - НЕ доступна для выдачи
        when(service.isStock(100)).thenReturn(false);

        BookLendManager manager = new BookLendManager(service);
        // пытаемся выдать книгу с ид 100 пользователю с ид 300
        manager.checkout(100, 300);
        // функция вызывалась только один раз
        verify(service, times(1)).isStock(100);
        // функция не вызывалась
        verify(service, never()).lend(anyInt(), anyInt());
        verifyNoMoreInteractions(service);
    }

}
