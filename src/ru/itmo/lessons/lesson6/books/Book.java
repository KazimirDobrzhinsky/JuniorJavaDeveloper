package ru.itmo.lessons.lesson6.books;

import java.util.Objects;

public class Book {
    private String title; // если стоит модификатор private -
    // значит что к свойству и методу
    // можно обратиться только из текущего класса
    private int pageCount;
    private Author author;

    // методы, позволяющие установить значения св-в
    // со всеми необходимыми проверками - сеттеры


    public Book() {
    }

    public Book(Author author) {
        this.author = Objects.requireNonNull(author, "author не может быть null");
    }

    public Book(String title, Author author) {
        // вызов другого конструктора
        this(author);
        setTitle(title);
    }

    public void setTitle(String titleValue) {
        if (titleValue == null || titleValue.length() < 3) {
            throw new IllegalArgumentException("Значние title от 3х символов"); // создание экземпляра ошибки
        }
        title = titleValue;
    }

    // методы которые возвращают свойства - геттеры
    public String getTitle() {return title;}

    public void setPageCount(int pageCount) {
        if (pageCount < 10) {
            throw new IllegalArgumentException("Кол-во страниц дб больше 10");
        }
        this.pageCount = pageCount; // this - ссылка на текущмй объект
    }

    public int getPageCount() {
        return pageCount;
    }

    public Author getAuthor() {
        return author;
    }
}
