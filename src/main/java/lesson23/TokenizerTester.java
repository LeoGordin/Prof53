package lesson23;

import lesson13.homework.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TokenizerTester {
    public static void main(String[] args) {
        //write();
        read();
    }
    public static void write()
    {
        Employee employee = new Employee(123, "Max Kotkov", 27, 32_500.7);
        try(
                PrintWriter printWriter = new PrintWriter("employee.txt");
                )
        {
            printWriter.println(
                    employee.getId() + "|" + employee.getName() + "|" + employee.getAge() +
                            "|" + employee.getSalary()
            );
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    public static void read()
    {
        try(
                FileReader fileReader = new FileReader("employee.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                )
        {
            String s = bufferedReader.readLine();
            StringTokenizer t = new StringTokenizer(s, "|");
            int id = Integer.parseInt(t.nextToken());
            String name = t.nextToken();
            int age = Integer.parseInt(t.nextToken());
            double salary = Double.parseDouble(t.nextToken());
            Employee employee = new Employee(id, name, age, salary);
            System.out.println(employee);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
