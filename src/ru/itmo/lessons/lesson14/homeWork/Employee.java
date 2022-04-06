package ru.itmo.lessons.lesson14.homeWork;


import ru.itmo.lessons.lesson14.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя менее 2х символов");
        }
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company.length() < 2) {
            throw new IllegalArgumentException("Название компании не может состоять из одного символа");
        }
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Зарплата должна быть больше 0");
        }
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 21) {
            throw new IllegalArgumentException("Возраст не может быть меньше 21");
        }
        this.age = age;
    }

    public Employee(String name, String company, int salary, int age) {
        setName(name);
        setCompany(company);
        setSalary(salary);
        setAge(age);
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[(int) (Math.random() * 11)], companies[(int) (Math.random() * 6)], ((int) (Math.random() * 2000 + 500)), ((int) (Math.random() * (60 - 21 + 1) + 21))));
        }
        return employees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}

// Создать список объектов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}

class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class CompanyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

