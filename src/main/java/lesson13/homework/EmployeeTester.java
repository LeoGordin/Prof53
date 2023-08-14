package lesson13.homework;

import java.util.*;

public class EmployeeTester {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(
                Arrays.asList(
                        new Employee(15, "John Smith", 28, 32000),
                        new Employee(10, "Alex Graham", 23, 41000),
                        new Employee(24, "Syvlia Cray", 33, 37500)
                )
        );

        System.out.println(employees);

        Collections.sort(employees); // страндартная сортировка по идентификатору

        System.out.println(employees);

        Collections.sort(employees, Employee.ageComparator);

        System.out.println(employees);

        compositeSort(
                employees,
                Arrays.asList(
                        Employee.salaryComparator.reversed(),
                        Employee.ageComparator,
                        Employee.nameComparator
                )
        );
        System.out.println(employees);

    }

    public static void compositeSort(List<Employee> e, List<Comparator<Employee>> c) {
        if(c != null && c.size() > 0) {
            Comparator<Employee> complexComparator = c.get(0);
            for(int i = 1; i < c.size(); i++)
            {
                complexComparator = complexComparator.thenComparing(c.get(i));
            }
            Collections.sort(e, complexComparator);
        }
    }


}
