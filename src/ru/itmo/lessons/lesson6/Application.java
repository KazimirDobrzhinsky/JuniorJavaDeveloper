package ru.itmo.lessons.lesson6;

import ru.itmo.lessons.lesson6.books.Author; // если классы в разных пакетах, то их нужно импортировать
import ru.itmo.lessons.lesson6.books.Book;
import ru.itmo.lessons.lesson6.books.Shelf;

// Полное имя класса - имя пакета + имя класса - ru.itmo.lessons.lesson6.Application
public class Application {
    public static void main(String[] args) {
        // класс - способ описания сущности, определяющий
        // её сосстояния и поведение
        // класс - набор свойств и методов будущих объектов

        // На основе класса создаются объекты
        // (экземпляры данного класса) - представители
        // данного класса, имеющие конкретное состояние и
        // поведение, определенное в класса

        // у каждого класса должна быть своя ответственность

        // чтобы создать экзмепляр класса

        Author author1 = new Author(); // объект класса Author
        // обращение к свойствам
        author1.name = "Tom"; // доступ к свойствам объекта осуществляется через точку
        author1.surname = "Crowed";
        Author author2 = new Author();
        author2.name = "Mike";
        author2.surname = "Thompson";

        // вызов метода
        author1.printFullName();
        author2.printFullName();

        String fullName = author1.getFullName();
        System.out.println(fullName);

        Book book1 = new Book();
        book1.setTitle("Война и мир");
        System.out.println(book1.getTitle());
        book1.setPageCount(22);

        Shelf shelf = new Shelf();
        shelf.addBook(book1);
        shelf.addBook(book1,book1,book1);
        // вывод имени автора первой книги на полке
        System.out.println(shelf.books[0].getAuthor().getFullName());
    }
}
