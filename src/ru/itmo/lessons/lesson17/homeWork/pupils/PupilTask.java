package ru.itmo.lessons.lesson17.homeWork.pupils;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PupilTask {
    public static void main(String[] args) {


        List<Pupil> pupils = new ArrayList<>(Arrays.asList(
                new Pupil(1, "Женя", Pupil.Gender.MALE, LocalDate.now().minusYears(1)),
                new Pupil(2, "Олег", Pupil.Gender.MALE, LocalDate.now().minusYears(1)),
                new Pupil(3, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Pupil(4, "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(1)),
                new Pupil(5, "Алексей", Pupil.Gender.MALE, LocalDate.now().minusYears(1)),
                new Pupil(6, "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(1)),
                new Pupil(7, "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(12)),
                new Pupil(8, "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(1)),
                new Pupil(9, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Pupil(10, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Pupil(11, "Григорий", Pupil.Gender.MALE, LocalDate.now().minusYears(1)),
                new Pupil(12, "Ирина", Pupil.Gender.FEMALE, LocalDate.now().minusYears(11))
        ));

        // TODO: Используя Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, ArrayList<Pupil>> genderArrayListMap = pupils.stream().
                collect(Collectors.
                        groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(genderArrayListMap);
        //  2. Найти средний возраст учеников
        Double avgAge = pupils.stream().collect(Collectors.
                averagingInt(pupil -> Period.between(pupil.getBirth(),LocalDate.now()).getYears()));
        System.out.println(avgAge);
        //  3. Найти самого младшего ученика
        Pupil smallOne = pupils.stream().min((pupil1, pupil2) -> pupil2.getBirth().compareTo(pupil1.getBirth())).get();
        System.out.println(smallOne);
        //  4. Найти самого старшего ученика
        Pupil bigOne = pupils.stream().max((pupil1, pupil2) -> pupil2.getBirth().compareTo(pupil1.getBirth())).get();
        System.out.println(bigOne);
        //  5. Собрать учеников в группы по году рождения
        Map<Integer, ArrayList<Pupil>> groupByAge = pupils.stream().collect(Collectors.groupingBy(pupil -> pupil.getBirth().getYear(), Collectors.toCollection(ArrayList::new)));
        System.out.println(groupByAge);
        //  6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        Collection<Pupil> uniqueByName = pupils.stream()
                .collect(Collectors.toMap(
                        Pupil::getName,
                        Function.identity(),((pupil, pupil2) -> pupil))).values();
        //pupils.stream().filter((pupil1, pupil2) -> pupil1.getName().equalsIgnoreCase(pupil2.getName()));
        //  7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        List<Pupil> pupilList = pupils.stream().sorted(Comparator
                        .comparing(Pupil::getGender)
                        .thenComparing(Pupil::getBirth)
                        .thenComparing((pupil1, pupil2) -> pupil2.getName().compareTo(pupil1.getName())))
                .collect(Collectors.toList());
        System.out.println(pupilList);
        System.out.println("111");
        //  8. Вывести в консоль всех учеников в возрасте от N до M лет
        Double n = 13.0;
        Double m = 20.0;
        pupils.stream().filter(pupil -> ((Period.between(pupil.getBirth(),LocalDate.now()).getYears()) <= m) && (Period.between(pupil.getBirth(),LocalDate.now()).getYears()) >=n)
                .forEach(System.out::println);
        //  9. Собрать в список всех учеников с именем=someName
        String someName = "Петр";
        List<Pupil> someNameList = pupils.stream().filter(pupil -> pupil.getName().equalsIgnoreCase(someName)).collect(Collectors.toList());
        //  10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> genderIntegerMap = pupils.stream().
                collect(Collectors.groupingBy(Pupil::getGender,Collectors.summingInt(pupil -> Period.between(pupil.getBirth(),LocalDate.now()).getYears())));
        System.out.println(genderIntegerMap);
    }
}