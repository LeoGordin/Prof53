package lesson28.exception;

public class Tester {
    public static void main(String[] args) {
        solution(0);
        solution(2);
    }
    // n = 0
    // n = 2
    public static void solution(int n)
    {
        // потестируйте и посмотрите какие исключения она может выбрасывать
        // оберните этот код в try-catch блок чтобы он эти исключения перехватывал
        // и обрабатывал выводя ошибки на экран
        try {
            int x = 10 / n;
            int[] array = new int[n];
            array[x] = 10;
        }
        catch (ArithmeticException e)
        {
            System.out.println("Arithmetic exception " + e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBoundsException " + e.getMessage());
        }
    }
}
