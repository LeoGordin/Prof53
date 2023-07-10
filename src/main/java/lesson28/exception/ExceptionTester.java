package lesson28.exception;

import static lesson28.exception.Tester.solution;

public class ExceptionTester {
    // Exception Исключение это специальная ситуация или ошибка при работе программы
    // исключения выбрасываются или виртуальной машиной JVM либо кодом
    // RuntimeException - ошибка программиста - не нужно проверять (unchecked)
    //      ArithmeticException, IndexOutOfBoundsException
    // Exception - проверяемые исключения - checked (IOException)
    // Error - семейство критических ошибок - выбрасываются JVM, восстановление невозможно
    //      OutOfMemoryException

    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 5));
            System.out.println(divide(3, 2));
            System.out.println(divide(311, 0));
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }

        System.out.println("THE END");

        try {
             //solution(0);
            solution(0);
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getClass());
        }
    }

    public static int divide(int a, int b) throws DivisionByZeroException {
        if (b == 0)
            throw new DivisionByZeroException("Не смей делить на ноль, смерд!");
        return a/b;
    }
}
