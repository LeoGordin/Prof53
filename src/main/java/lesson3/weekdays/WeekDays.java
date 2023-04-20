package lesson3.weekdays;

import java.util.Arrays;

public enum WeekDays {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static void main(String[] args) {
        System.out.println(MONDAY);
        System.out.println(SUNDAY.ordinal()); //порядковый номер
        System.out.println(
                Arrays.toString(
                        WeekDays.values()
                )
        );
        WeekDays day = WeekDays.FRIDAY;
        WeekDays day1 = WeekDays.valueOf("WEDNESDAY");

    }

    public boolean isWorkDay()
    {
        // возвращать true если день с понедельника по пятницу включительно
        return !isWeekEnd();
    }

    public boolean isWeekEnd()
    {
        // возвращать true если день суббота или воскресенье
        return ordinal() == 5 || ordinal() == 6;
    }


}
