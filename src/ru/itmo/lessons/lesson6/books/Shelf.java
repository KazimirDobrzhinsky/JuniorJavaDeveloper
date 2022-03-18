package ru.itmo.lessons.lesson6.books;

public class Shelf {
    private String color = "белый";
    public Book[] books = new Book[10];

    public void addBook(Book book) { // Добавление одной книги на полку
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        System.out.println("Нет места");
    }

    public void addBook(Book... books) { // Добавление нескольких книги на полку (перегруженный метод

    }


}
