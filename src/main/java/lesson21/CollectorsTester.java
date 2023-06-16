package lesson21;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsTester {
    public static void main(String[] args) {
        // Collectors
        //      сгруппировать элементы потока
        //      обсчитать статистику по потоку
        //      сохранить элементы потока в коллекцию на наш выбор

        List<Student> students = List.of(
                new Student("Michael", "Svetlov", 24),
                new Student("Alexander", "Svetlov", 28),
                new Student("Daria", "Petrovskaya", 19),
                new Student("Maria", "Drobysheva", 19),
                new Student("Max", "Pavlov", 24)
        );

        System.out.println(
                students.stream()
                        .filter(s -> s.getLastName().toLowerCase().contains("s"))
                        .collect(Collectors.toList())
        );

//        List<Student> filteredStudents =
//                students.stream()
//                        .filter(s -> s.getLastName().toLowerCase().contains("s"))
//                        //.collect(Collectors.toList()) // список ArrayList
//                        //.collect(Collectors.toSet()) // сет
//                        // .collect(Collectors.toUnmodifiableList()) // только для чтения
//                        //.collect(Collectors.toUnmodifiableSet()) // сет только для чтения
//                        .collect(
//                                Collectors.toCollection(
//                                        LinkedList::new


        Collection<Student> filteredStudents =
                students.stream()
                        .filter(s -> s.getLastName().toLowerCase().contains("s"))
                        //.collect(Collectors.toList()) // список ArrayList
                        //.collect(Collectors.toSet()) // сет
                        // .collect(Collectors.toUnmodifiableList()) // только для чтения
                        //.collect(Collectors.toUnmodifiableSet()) // сет только для чтения
                        .collect(
                                Collectors.toCollection(
                                        LinkedList::new // указажем вид коллекции для сборки
                                )
                        );
        System.out.println(filteredStudents);

        System.out.println(
                students.stream()
                        .map(Student::getLastName)
                        .collect(Collectors.toSet()));

// сгруппируем студентов по их гендеру
        Map<Boolean, List<Student>> studentsByGender =
                students.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        s -> s.getLastName().endsWith("a")
                                )
                        );

        System.out.println(
                students.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        s -> s.getAge() > 20
                                )
                        )
        );

        // groupingBy позволяет группировать элементы потока по любому критерию
        Map<Integer, List<Student>> studentsByAge =
                students.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Student::getAge
                                )
                        );

        System.out.println(studentsByAge);
        System.out.println(
                students.stream()
                        .collect(Collectors.groupingBy(
                                        s -> s.getFirstName().subSequence(0, 1)
                                )
                        )
        );

// создадим Map из "имя" + " " + "фамилия" на возраст
        Map<String, Integer> nameToAge =
                students.stream()
                        .collect(
                                Collectors.toMap(
                                        s -> s.getFirstName() + " " + s.getLastName(),
                                        Student::getAge
                                )
                        );
        System.out.println(nameToAge);

        Map<String, String> firstToLast =
                students.stream()
                        .collect(
                                Collectors.toMap(
                                        Student::getFirstName,
                                        Student::getLastName
                                )
                        );

        System.out.println(firstToLast);

        // Статистика
        DoubleSummaryStatistics ageStatistics =
                students.stream()
                        .collect(
                                Collectors.summarizingDouble(Student::getAge)
                        );

        System.out.println("max: " + ageStatistics.getMax());
        System.out.println("average: " + ageStatistics.getAverage());
        System.out.println("sum: " + ageStatistics.getSum());

        // способ определить максимальное значение
        Optional<Student> maxAgeStudent =
                students.stream()
                        .max(Comparator.comparingInt(Student::getAge));

        System.out.println(maxAgeStudent);

        Map<Integer, Integer> numberOfStudentsInAge = studentsByAge
                .entrySet() // превращения Map  в Set из пар "ключ"->"значение"
                .stream()
                .map(
                        pair -> new AbstractMap.SimpleEntry<>(pair.getKey(), pair.getValue().size())
                ).collect(Collectors.toMap(
                                AbstractMap.SimpleEntry::getKey,
                                AbstractMap.SimpleEntry::getValue
                        )
                );

        System.out.println(numberOfStudentsInAge);

        System.out.println(studentsByGender);
        // Map<Boolean, List<Student>> -> Map<String, Double>
        // false -> "m", true -> "f"
        // List<Student> -> Double (средний возраст)

        Map<String, Double> genderToAverageAge =
                studentsByGender.entrySet().stream() // Stream<   Pair<Boolean, List<Student>   >
                        .map(
                                pair -> new AbstractMap.SimpleEntry<>(
                                        pair.getKey() ? "f" : "m",
                                        pair.getValue().stream().mapToDouble(Student::getAge).average().orElse(0)
                                )
                        )
                        .collect(
                                Collectors.toMap(
                                        AbstractMap.SimpleEntry::getKey,
                                        AbstractMap.SimpleEntry::getValue
                                )
                        );

        System.out.println(genderToAverageAge);

// Кастомные коллекторы

        // Collector<T,A,R>
        // T - тип элемента потока
        // A - тип аккумулятора, в который в коллекторе сохраняются значения
        // R - тип возвращаемого значения
        // сделаем коллектор, который сформирует для нас
        // Map<Integer, List<Student> - группировку из возраста в список студентов
        // с этим возрастом
        Collector<
                Student, //  тип элемкнта в потоке
                Map<Integer, List<Student>>, // тип аккумулятора
                Map<Integer, List<Student>> // тип возвращаемого значения
                >
                ageCollector = new Collector<Student, Map<Integer, List<Student>>, Map<Integer, List<Student>>>() {
            @Override
            public Supplier<Map<Integer, List<Student>>> supplier() {
                // supplier должна вернуть пустой контейнер для аккумуляции
                return HashMap::new;
            }

            @Override
            public BiConsumer<Map<Integer, List<Student>>, Student> accumulator() {
                // accumulator должен каким-то образом "аккумулировать" (обрабатывать) студента
                return (map, s) -> {
                    List<Student> studs = map.get(s.getAge()); // список студентов нашего возраста
                    if (studs == null) // если такого списка пока нет,
                        studs = new ArrayList<>(); // создаем
                    studs.add(s); // добавляемся
                    map.put(s.getAge(), studs); // сохраняем в аккумулятор измененный список для возраста
                };
            }


            @Override
            public BinaryOperator<Map<Integer, List<Student>>> combiner() {
                // combiner используется для сливания аккумуляторов при параллельном выполнении
                return (
                        m1, // один аккумулятор
                        m2 // второй аккумулятор
                ) -> {
                    m1.putAll(m2);
                    return m1;
                };
            }



            // finisher преобразует аккумулятор в возращаемое значение
            @Override
            public Function<Map<Integer, List<Student>>, Map<Integer, List<Student>>> finisher() {
                // return Function.identity(); // возвращает свое входное значение
                return accumulator -> accumulator;
            }

            // Characteristics.UNORDERED данные могут возвращаться в произвольном порядке
            // Characteristics.CONCURRENT аккумулятор может выполняеться многопоточно
            // Characteristics.IDENTITY_FINISH можно не выполнять finisher
            @Override
            public Set<Characteristics> characteristics() {
                return Set.of(Characteristics.UNORDERED);
            }
        };

        System.out.println(
                students.stream()
                        .collect(ageCollector)
        );

// напишите коллектор который суммирует длину всех передаваемых в него строк
        Collector<String, Integer, Integer> stringLengthSummator = new Collector<String, Integer, Integer>() {

            // supplier должен вернуть аккумулятор с правильным начальным значением
            @Override
            public Supplier<Integer> supplier() {
                return () -> 0;
            }

            // нужно аккумулировать длину текущей строки
            @Override
            public BiConsumer<Integer, String> accumulator() {
                return (i, s) -> i = i + s.length();
            }

            // для сливания данных из двух аккумуляторов при
            // параллельном выполнении
            @Override
            public BinaryOperator<Integer> combiner() {
                return (i1, i2) -> {
                    i1 = i1 + i2;
                    return i1;
                };
            }

            // преобразование аккумулятора в возвращаемое значение
            @Override
            public Function<Integer, Integer> finisher() {
                return integer -> integer;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Set.of(Characteristics.UNORDERED);
            }
        };
    }

}
