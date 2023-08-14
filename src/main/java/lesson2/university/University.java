package lesson2.university;

public class University {
    public static void main(String[] args) {
        Student max = new Student("Max", 20, 2, "music");
        Staff alex = new Staff("Alex", 43, 50_000, "math");

        Student margareth = new Student("Margareth", 21, 3, "politics");
        // массив и студентов и работников

        Person [] people = new Person[10];
        people[0] = max;
        people[1] = alex;
        // добавьте маргарет в список
        // спомощью цикла посчитайте суммарный возраст людей в университете
        people[2] = margareth;
        int sum = 0;
        for(int i = 0; i < people.length; i++)
        {
            if(people[i] != null) {
                sum += people[i].getAge();
                // по ссылке на экземпляр базового класса
                // вызывается функция переопределнная в производном
                people[i].introduce();
            }
        }
        System.out.println("summary age: " + sum);
        // people[1].getSalary(); // в people лежат Person
    }
}