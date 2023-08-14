package lesson3.date;

public class MyDate {
    private int year, month, day;
    // month 1-12
    // day 1-
    // можно сделать month через enum

    // добавьте конструкторы геттеры сеттеры
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // добавьте функцию
    public void add(int days)
    {
        int daysLeft = days;
        int currentDay = day;
        int currentMonth = month;
        int currentYear = year;
        while (daysLeft > 0)
        {
            // определим сколько дней осталось до конца текущего месяца
            int daysLeftInCurrentMonth = daysInMonth(currentMonth, currentYear) - currentDay;
            // если оставшееся количество дней в месяце больше чем daysLeft
            if(daysLeftInCurrentMonth >= daysLeft)
            {
                currentDay += daysLeft;
                daysLeft = 0;
            }
            else {
                daysLeft -= (daysLeftInCurrentMonth + 1);
                currentDay = 1;
                if(currentMonth == 12)
                {
                    currentMonth = 1;
                    currentYear++;
                }
                else {
                    currentMonth++;
                }
            }
        }
        year = currentYear;
        month = currentMonth;
        day = currentDay;
    }

    // сколько дней в конкретном месяце конкретного года
    private int daysInMonth(int month, int year)
    {
        switch (month)
        {
            case 2:
            {
                if(isLeapYear(year))
                    return 29;
                else return 28;
            }
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            default:
                return 30;
        }
    }

    // является ли год високосным
    private boolean isLeapYear(int year)
    {
        if(year % 400 == 0)
            return true;
        if(year % 100 == 0)
            return false;
        return year % 4 == 0;
    }

    @Override
    public String toString() {
        return "year=" + year +
                ", month=" + month +
                ", day=" + day;
    }

    public static void main(String[] args) {
        MyDate d = new MyDate(2022, 4, 18);
        // d.add(5);
        // d.add(30);
        d.add(365);
        System.out.println(d);
    }
}
