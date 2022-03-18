package ru.itmo.lessons.lesson6.books;

public class Author {
    // свойства/характеристики/поля/атрибуты объекта
    public String name;
    public String surname;
    // public - модификатор доступа

    // объявление методов (void - ничего не возвращает)
    public void printFullName() {
        // можно использовать return; чтобы прервать работу метода
        System.out.println(name + " " +surname);
    }

    public String getFullName() {
        // return - возвращает результат работы метода
        // прерывает работу метода, инструкции после return
        // не выполняются
        return name + " " + surname;

    }
}
