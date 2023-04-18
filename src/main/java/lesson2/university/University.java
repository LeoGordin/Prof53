package lesson2.university;

public class University {
    public static void main(String[] args) {
        Student max = new Student("Max", 20, 2, "Music");
        Staff alex = new Staff("Alex", 43, 50000, "Mathematics");
        Student margareth = new Student("Margareth", 21, 3, "Politics");

        //массив и студентов и работников

        Person [] people = new Person[10];
        people[0] = max;
        people[1] = alex;
        people[2] = margareth;

        int sum = 0;
        for(int i = 0; i < people.length; i++)
        {
            if(people[i] != null)
            {
                sum += people[i].getAge();
                people[i].introduce();
            }
        }
        System.out.println("summary age: " + sum);

        }


    }

