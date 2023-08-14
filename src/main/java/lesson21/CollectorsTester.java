//package lesson21;
//
//import java.util.*;
//import java.util.function.BiConsumer;
//import java.util.function.BinaryOperator;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class CollectorsTester {
//    public static void main(String[] args) {
//        // Collectors
//        //      сгруппировать элементы потока
//        //      обсчитать статистику по потоку
//        //      сохранить элементы потока в коллекцию на наш выбор
//
////        List<Student> students = List.of(
////                new Student("Michael", "Svetlov", 24),
////                new Student("Alexander", "Svetlov", 28),
////                new Student("Daria", "Petrovskaya", 19),
////                new Student("Maria", "Drobysheva", 19),
////                new Student("Max", "Pavlov", 24)
////        );
//
//        // соберите студентов у которых в фамилии есть буква s
//        // в любом регистре в List
//        // и потом этот список распечатайте
//
////        Collection<Student> filteredStudents =
////                students.stream()
////                        .filter(s -> s.getLastName().toLowerCase().contains("s"))
////                        //.collect(Collectors.toList()) // список ArrayList
////                        //.collect(Collectors.toSet()) // набор
////                        // .collect(Collectors.toUnmodifiableList()) // список только для чтения
////                        //.collect(Collectors.toUnmodifiableSet()) // набор только для чтения
////                        .collect(
////                                Collectors.toCollection(
////                                        LinkedList::new // указажем вид коллекции для сборки
////                                        // TreeSet::new
////                                )
////                        );
////        System.out.println(filteredStudents);
//
//
//        // соберите все уникальные фамилии студентов
//        // в коллекцию по возрастанию
////        Collection<String> uniqueLastNames = students.stream()
////                .map(Student::getLastName)
////                // .collect(Collectors.toSet())
////                .collect(Collectors.toCollection(TreeSet::new));
//
////        System.out.println(
////                uniqueLastNames
////        );
////
////        // сгруппируем студентов по их гендеру
////        // partitioningBy может поделить поток только на две части
////        Map<Boolean, List<Student>> studentsByGender =
////                students.stream()
////                        .collect(
////                                Collectors.partitioningBy(
////                                        s -> s.getLastName().endsWith("a")
////                                )
////                        );
////
////        System.out.println(studentsByGender);
//
//        // разбейте студентов на тех кто старше 20 лет и моложе
//        // studentsOlderThan20
////        Map<Boolean, List<Student>> studentsOlderThan20 =
////                students.stream()
////                        .collect(
////                                Collectors.partitioningBy(s -> s.getAge() > 20)
////                        );
////        System.out.println(studentsOlderThan20);
////
////        // groupingBy позволяет группировать элементы потока по любому критерию
////        Map<Integer, List<Student>> studentsByAge =
////                students.stream()
////                        .collect(
////                                Collectors.groupingBy(
////                                        s -> s.getAge()
////                                )
////                        );
////        System.out.println(studentsByAge);
//
//        // сгруппируйте студентов по первой букве имени
////        Map<String, List<Student>> studentsByFirstNameLetter =
////                students.stream()
////                        .collect(
////                                Collectors.groupingBy(
////                                        s -> s.getFirstName().substring(0, 1)
////                                )
////                        );
////        System.out.println(studentsByFirstNameLetter);
////
////        // создадим Map из "имя" + " " + "фамилия" на возраст
////        Map<String, Integer> nameToAge =
////                students.stream()
////                        .collect(
////                                Collectors.toMap(
////                                        s -> s.getFirstName() + " " + s.getLastName(),
////                                        Student::getAge
////                                )
////                        );
////        System.out.println(nameToAge);
//
//        // сделайте Map из имени в фамилию
//        Map<String, String> firstToLast =
//                students.stream()
//                        .collect(
//                                Collectors.toMap(
//                                        Student::getFirstName,
//                                        Student::getLastName
//                                )
//                        );
//        System.out.println(firstToLast);
//
//        // Статистика
//        DoubleSummaryStatistics ageStatistics =
//                students.stream()
//                        .collect(
//                                Collectors.summarizingDouble(s -> s.getAge())
//                        );
//        System.out.println("max: " + ageStatistics.getMax());
//        System.out.println("average: " + ageStatistics.getAverage());
//        System.out.println("sum: " + ageStatistics.getSum());
//
//        // способ определить максимальное значение
//        Optional<Student> maxAgeStudent =
//                students.stream()
//                        .collect(
//                                Collectors.maxBy(Comparator.comparing(Student::getAge))
//                        );
//
//        System.out.println(maxAgeStudent);
//
//        System.out.println(studentsByAge); // Map<Integer, List<Student>>
//
//        Map<Integer, Integer> numberOfStudentsInAge = studentsByAge
//                .entrySet() // превращения Map  в Set из пар "ключ"->"значение"
//                .stream()
//                .map(
//                        pair -> new AbstractMap.SimpleEntry<>(pair.getKey(), pair.getValue().size())
//                ) // Stream<   SimpleEntry<Integer, Integer>  >
//                .collect(
//                        Collectors.toMap(
//                                pair -> pair.getKey(),
//                                pair -> pair.getValue()
//                        )
//                );
//
//        System.out.println(numberOfStudentsInAge);
//
//
//        System.out.println(studentsByGender);
//        // Map<Boolean, List<Student>> -> Map<String, Double>
//        // false -> "m", true -> "f"
//        // List<Student> -> Double (средний возраст)
//
//        Map<String, Double> genderToAverageAge =
//                studentsByGender.entrySet().stream() // Stream<   Pair<Boolean, List<Student>   >
//                        .map(
//                                pair -> new AbstractMap.SimpleEntry<>(
//                                        pair.getKey() ? "f" : "m",
//                                        pair.getValue().stream().mapToDouble(Student::getAge).average().orElse(0)
//                                )
//                        )
//                        .collect(
//                                Collectors.toMap(
//                                        AbstractMap.SimpleEntry::getKey,
//                                        AbstractMap.SimpleEntry::getValue
//                                )
//                        );
//
//        System.out.println(genderToAverageAge);
//
//        // Кастомные коллекторы
//
//        // Collector<T,A,R>
//        // T - тип элемента потока
//        // A - тип аккумулятора, в который в коллекторе сохраняются значения
//        // R - тип возвращаемого значения
//        // сделаем коллектор, который сформирует для нас
//        // Map<Integer, List<Student> - группировку из возраста в список студентов
//        // с этим возрастом
//        Collector<
//                Student, //  тип элемкнта в потоке
//                Map<Integer, List<Student>>, // тип аккумулятора
//                Map<Integer, List<Student>> // тип возвращаемого значения
//                >
//                ageCollector = new Collector<>() {
//            // supplier должна вернуть пустой контейнер для аккумуляции
//            // при старте потока
//            @Override
//            public Supplier<Map<Integer, List<Student>>> supplier() {
//                return HashMap::new;
//            }
//
//            // accumulator должен каким-то образом "аккумулировать" (обрабатывать) студента
//            @Override
//            public BiConsumer<Map<Integer, List<Student>>, Student> accumulator() {
//                return (map, s) -> {
//                    List<Student> studs = map.get(s.getAge()); // список студентов нашего возраста
//                    if (studs == null) // если такого списка пока нет,
//                        studs = new ArrayList<>(); // создаем
//                    studs.add(s); // добавляемся
//                    map.put(s.getAge(), studs); // сохраняем в аккумулятор измененный список для возраста
//                };
//            }
//
//            // combiner используется для сливания аккумуляторов при параллельном выполнении
//            // при окончании потока
//            @Override
//            public BinaryOperator<Map<Integer, List<Student>>> combiner() {
//                return (
//                        m1, // один аккумулятор
//                        m2 // второй аккумулятор
//                ) -> {
//                    m1.putAll(m2);
//                    return m1;
//                };
//            }
//
//            // finisher преобразует аккумулятор в возращаемое значение
//            @Override
//            public Function<Map<Integer, List<Student>>, Map<Integer, List<Student>>> finisher() {
//                // return Function.identity(); // возвращает свое входное значение
//                return accumulator -> accumulator;
//            }
//
//            // Characteristics.UNORDERED данные могут возвращаться в произвольном порядке
//            // Characteristics.CONCURRENT аккумулятор может выполняеться многопоточно
//            // Characteristics.IDENTITY_FINISH можно не выполнять finisher
//            @Override
//            public Set<Characteristics> characteristics() {
//                return Set.of(Characteristics.UNORDERED);
//            }
//        };
//
//
//        System.out.println(
//                students.stream()
//                        .parallel() // выполнять в несколько потоков выполнения
//                        .collect(ageCollector)
//        );
//
//        // напишите коллектор который суммирует длину всех передаваемых в него строк
//        Collector<
//                String,
//                List<Integer>,
//                Integer
//                > stringLengthSummator = new Collector<>() {
//
//            // supplier должен вернуть аккумулятор с правильным начальным значением
//            @Override
//            public Supplier<List<Integer>> supplier() {
//                return ArrayList::new;
//            }
//
//            // нужно аккумулировать длину текущей строки
//            @Override
//            public BiConsumer<List<Integer>, String> accumulator() {
//                return (integers, s) -> integers.add(s.length());
//            }
//
//            // для сливания данных из двух аккумуляторов при
//            // параллельном выполнении
//            @Override
//            public BinaryOperator<List<Integer>> combiner() {
//                return (l1, l2) -> {
//                    l1.addAll(l2);
//                    return l1;
//                };
//            }
//
//            // преобразование аккумулятора в возвращаемое значение
//            @Override
//            public Function<List<Integer>, Integer> finisher() {
//                return integers -> integers.stream().mapToInt(i -> i).sum();
//            }
//
//            @Override
//            public Set<Characteristics> characteristics() {
//                return Set.of(Characteristics.UNORDERED);
//            }
//        };
//
//
//        System.out.println(
//                Set.of("abc", "def", "1").stream()
//                        .collect(stringLengthSummator) // 7
//        );
//
//
//        System.out.println(
//                Stream.of("one", "two", "three", "eleven")
//                        .collect(
//                                Collectors.joining(
//                                        ", ", "{", "}"
//                                )
//                        )
//        );
//    }
//}
