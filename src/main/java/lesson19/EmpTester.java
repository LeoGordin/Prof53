package lesson19;

import java.util.*;
import java.util.stream.Collectors;

public class EmpTester {
    public static void main(String[] args) {
        List<Emp> employees = new ArrayList<>(
                Arrays.asList(
                        new Emp("Max Petrov", 22, "programmer"),
                        new Emp("Ivan Shapovalov", 33, "analyst"),
                        new Emp("Semen Dezhnev", 55, "manager"),
                        new Emp("Oleg Petrov", 19, "intern"),
                        new Emp("Katerina Dragova", 31, "programmer"),
                        new Emp("Nikolas Spivakov", 23, "analyst"),
                        new Emp("Boris Moiseev", 48, "manager"),
                        new Emp("Petr Sveshnikov", 37, "analyst"),
                        new Emp("Alex Con", 33, "analyst"),
                        new Emp("Olga Filimonova", 27, "programmer")
                )
        );


        employees.stream()
                .min(Comparator.comparingInt(Emp::getAge))
                .ifPresent(System.out::println);

        System.out.println(
                employees.stream()
                        .filter(e -> e.getName().endsWith("a"))
                        .map(emp -> emp.getName().split(" ")[1])
                        .toList()
        );

        employees.stream()
                .mapToDouble(Emp::getAge)
                .average()
                .ifPresent(System.out::println);

        System.out.println(employees.stream()
                .filter(e -> e.getPosition().equals("programmer"))
                .filter(e -> !e.getName().endsWith("a"))
                .count()
        );

        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(e -> e.getAge() >= 40))
        );

        // разделите всех работников на 2 группы
        // старше 40 лет (true) и младше 40 лет (false)
        System.out.println("===сгруппировать старше и младше 40 лет===");
        Map<Boolean, List<Emp>> emps =
                employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        e -> e.getAge() > 40
                                )
                        );
        System.out.println(emps);

        System.out.println(emps.get(false).stream().max(Comparator.comparing(Emp::getAge)));

        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(Emp::getPosition))

        );

        Map<String, List<Emp>> byProfession =
                employees.stream()
                        .collect(Collectors.groupingBy(Emp::getPosition));
        System.out.println(byProfession);

        System.out.println(
                byProfession.entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey,
                                pair -> pair.getValue().size()))
        );
        // Вернуть средний возраст мужчин и женщин - у женщин фамилия оканчивается на "a" -
        // в виде Map<Boolean, Double> - ключ "true" соответствует женщинам
        System.out.println("===средний возраст женщин и мужчин===");
        System.out.println(
                employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        emp -> emp.getName().endsWith("a")
                                )
                        )
                        .entrySet().stream()
                        .map(
                                entry -> new AbstractMap.SimpleEntry<>(
                                        entry.getKey(),
                                        entry.getValue().stream().mapToDouble(Emp::getAge).average().orElse(0)
                                )
                        )
                        .collect(Collectors.toList())

        );

// Распечатать работников с самым часто встречающимся возрастом
        System.out.println("===работники с самым частым возрастом===");
        employees.stream()
                .collect(
                        Collectors.groupingBy(Emp::getAge)
                )
                .entrySet().stream()
                .sorted((p1, p2) -> p2.getValue().size() - p1.getValue().size())
                .limit(1)
                .map(Map.Entry::getValue)
                .forEach(System.out::println);


    }
}
