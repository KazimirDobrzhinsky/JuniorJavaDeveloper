package ru.itmo.lessons.lesson14.homeWork;



import java.util.Comparator;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        List<Employee> list1 = Employee.employeeGenerator(4);
        System.out.println(list1);
        Comparator<Employee> employeeComparator1 = new ru.itmo.lessons.lesson14.homeWork.NameComparator();
        list1.sort(employeeComparator1);
        System.out.println(list1);

        Comparator<Employee> employeeComparator2 = new ru.itmo.lessons.lesson14.homeWork.NameComparator().thenComparing(new SalaryComparator());
        list1.sort(employeeComparator2);
        System.out.println(list1);

        Comparator<Employee> employeeComparator3 = new ru.itmo.lessons.lesson14.homeWork.NameComparator().thenComparing(new SalaryComparator()).thenComparing(new AgeComparator().thenComparing(new CompanyComparator()));
        list1.sort(employeeComparator3);

        System.out.println(list1);
    }


}
