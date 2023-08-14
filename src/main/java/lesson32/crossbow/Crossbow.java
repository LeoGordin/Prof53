package lesson32.crossbow;

public class Crossbow {
    private int arrows = 10;

    synchronized public void fire()
    {
        for(int i = arrows; i >= 0; i--)
        {
            if(i != 0)
            {
                System.out.println("Выстрелили стрелой " + (arrows - i + 1) );
            }
            else {
                System.out.println("Стрелы закончились");
                arrows = 0;
                try {
                    wait(); // блокирует поток на мютексе
                    // пока кто-то не вызовет для мютекса операцию notify()
                } catch (InterruptedException e) {

                }
                System.out.println("Добавили новых стрел, " + arrows);
            }
        }
    }

    synchronized public void reload()
    {
        System.out.println("Добавляем новых стрел");
        arrows = 10;
        notify();
    }
}
