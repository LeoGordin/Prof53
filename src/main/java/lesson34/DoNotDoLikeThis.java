package lesson34;

public class DoNotDoLikeThis {
    public static void main(String[] args) {
        new Thread(() -> {String result = getName(); startNewThread(result);  }).start();
    }

    private static void startNewThread(String result) {
        new Thread(() -> {int l = getLength(result); finish(l); }).start();
    }

    private static void finish(int l) {
        System.out.println("result is: " + l);
    }

    public static String getName()
    {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(System.currentTimeMillis() % 2 == 0)
            throw new RuntimeException("hello");
        return "Alex";
    }

    public static Integer getLength(String s)
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s.length();
    }
}
