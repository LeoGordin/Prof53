package lesson19;

import lesson2.crossword.A;

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

        // распечатайте самого молодого работника
        System.out.println("===самый молодой===");
        employees.stream()
                .min(Comparator.comparingInt(Emp::getAge))
                .ifPresent(System.out::println);

        employees.stream()
                .sorted(Comparator.comparing(Emp::getAge))
                .findFirst()
                .ifPresent(System.out::println);

        // распечатайте фамилии всех женщин - оканчивающиеся на "a"
        // Filimonova , Drogova
        System.out.println("===фамилии женщин===");
        System.out.println(
                employees.stream()
                        .filter(e -> e.getName().endsWith("a"))
                        .map(e -> e.getName().split(" ")[1])
                        .collect(Collectors.toList())
        );

        // найдите средний возраст
        System.out.println("===средний возраст===");
        System.out.println(
                employees.stream()
                        .mapToDouble(Emp::getAge)
                        .average()
        );

        // посчитайте программистов мужчин
        System.out.println("===количество программистов мужчин===");
        System.out.println(
                employees.stream()
                        .filter(e -> e.getPosition().equals("programmer"))
                        .filter(e -> !e.getName().endsWith("a"))
                        .count()
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

        // найдите профессию самого старшего из "молодых" -
        // тех кому <= 40 лет
        System.out.println("===профессия самого старшего из 'молодых'===");
        emps.get(false).stream()
                .max(Comparator.comparing(Emp::getAge))
                .ifPresent(System.out::println);

        // сгруппируйте всех работников по професии
        System.out.println("===работники по профессии===");
        Map<String, List<Emp>> byProfession =
                employees.stream()
                        .collect(
                                Collectors.groupingBy(Emp::getPosition)
                        );
        System.out.println(
                byProfession
        );

        // посчитаем количество людей в профессии
        System.out.println("===количество работников по профессии===");
        System.out.println(
                byProfession.entrySet().stream()
                        .collect(
                                Collectors.toMap(
                                        pair -> pair.getKey(),
                                        pair -> pair.getValue().size()
                                )
                        )
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
                .map(pair -> pair.getValue())
                .forEach(System.out::println);
    }

}
