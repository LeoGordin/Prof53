package lesson28.exception;

import java.io.IOException;

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
            System.out.println(divide(14, 2));
            System.out.println(divide(10, 0));
            System.out.println(divide(3, 8));
        }
        catch (Exception e)
        {
            System.out.println("got and exception: " + e.getMessage());
        }
//        catch (DivisionByZeroException | IOException e)
//        {
//            System.out.println("got and exception: " + e.getMessage());
//        }
//        catch (IOException e)
//        {
//            System.out.println("got an io exception: " + e.getMessage());
//        }
        finally {
            // способ очищения ресурсов
            // закрытия чего-нибудь
            System.out.println("finally");
        }
        System.out.println("Program ends");
    }



    public static int divide(int a, int b) throws DivisionByZeroException, IOException {
        if(b == 0) {
            throw new DivisionByZeroException("делить на нуль нельзя!");
        }
        return a/b;
    }



}
