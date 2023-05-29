package lesson13.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lesson13.homework.Employee.compositeSort;

public class EmployeeTester {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(
                Arrays.asList(
                        new Employee(15, "John Smith", 28, 32000),
                        new Employee(10, "Alex Graham", 23, 31000),
                        new Employee(24, "Syvlia Cray", 33, 37500)
                )
        );

        System.out.println(employees);
        Collections.sort(employees);

        System.out.println(employees);

        compositeSort(employees, Arrays.asList(
                Employee.ageComparator,
                Employee.salaryComparator,
                Employee.nameComparator.reversed()
        ));
    };
}
