package lesson28.exception;

// Exception - семейство исключений которые необходимо проверять
public class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}
