package lesson5;

import java.util.Arrays;

public class FifthLesson {
    public static void main(String[] args) {

        // char - примитивный тип данных 16 битный символ Unicode
        // от 0 до 65536 / '\u0000' до '\uffff'

        char char1 = 'J'; // char - mandatory with single quote
        char char2 = 74;
        char char3 = '\u0044';

        System.out.println(char1);
        System.out.println("\nСтроки");

        // Строка - упорядоченная последовательность символов
        // Строка - ссылочный тип, экземпляр класса String
        // Строки задаются:
        // 1. в двойных кавычках
        // 2. new String() - используем только в том случае, когда
        // не получается испльзовать двойные кавычки
        // Строки неизменны, можно лишь создать новую  существующей

        System.out.println("Строковый литерал"); // Это тоже экземпляр класса string, но на него нельзя сослаться

        char[] chars = {'\u004A', '\u004A', '\u0044'};
        String jjdString = new String(chars);
        System.out.println(jjdString);
        System.out.println(jjdString.length());

        char[] chars1 = {'\uD83D', '\uDC38'}; // суррогатная пара чаров
        String frogString = new String(chars1);
        System.out.println(frogString); // 🐸
        System.out.println(frogString.length());

        System.out.println(frogString.codePoints().count());

        // Хранение строк до JAVA 9: массив char[] в кодировке UTF-16
        // Каждый чар был представлен двумя байтами

        // Начиная с 9 версии строки (компактные сроки) храняться как массив
        // byte[] + кодировка LATIN1 или UTF-16

        // Пул строк хранит только одну копию строкового литерала
        // В пуле строк всегда храняться уникальные строки
        // Пул строк:

        String string1 = "Строка";  // Пул строк: "Строка"
        String string2 = "Строка";  // Пул строк: "Строка"
        String string3 = new String("Строка");  // Так строка не попадает в пул строк, но создается новый объект

        System.out.println(string1 == string2);
        System.out.println(string1 == string3);
        System.out.println(string1.equals(string3));

        String internString = string3.intern(); // возвращает ссылку на строку из пула,
        // либо если она отсутствует, то добавляет её в пул и возвращает

        System.out.println(internString);

        string1 = "Строка";
        string2 = "Строка";

        // строки не сравниваются через == также как и любые другие ссылочные типы - так получается сравнение ссылок, а не самих объектов
        // Сравнение строк equals

        System.out.println(string1.equals(string2));
        System.out.println("строка".equals(string2));
        System.out.println("строка".equalsIgnoreCase(string2));

        string2 = null;

        System.out.println("строка".equals(string2));
        // System.out.println(string2.equals("строка")); // Ошибка NullPointerException появляется когда вызывается
        // метод либо необходимо уточнить свойство у null

        System.out.println(string2 == null); // true
        System.out.println(string2 != null); // false

        string1 = "Java";
        string2 = "Python";

        // конкатенация строк

        String concatString = string1 + " :: " + string2;
        System.out.println(concatString);

        concatString = string1.concat(" :: ");
        System.out.println(concatString);
        concatString = string1.concat(" :: ").concat(string2);
        System.out.println(concatString);

        concatString = String.join(" :: ", string1, string2, string3);
        System.out.println(concatString);

        StringBuilder concatStringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            concatStringBuilder.append(i); // так делать нельзя такак на каждой итерации
            // создается новый объект
        }
        concatString = concatStringBuilder.toString();

        System.out.println(concatString);

        // StringBuilder - работает быстрее
        // StringBuffer - потокобезопасный
        // Конкатенация с использованием методов выше позволяет избежать создания новых объектов

        concatString = "Начало строки ";
        StringBuilder sb = new StringBuilder(concatString);

        sb.append(string1);
        System.out.println(sb);

        sb.append(string1).append(" :: ").append(string2);
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb2.append(i).append(" ");
        }

        String sbString = sb2.toString();
        System.out.println(sbString);

        // метод split

        String langs = "Java, Python, JavaScript";
        String[] langArr = langs.split(", ");
        System.out.println(Arrays.toString(langArr));
        System.out.println(langArr[1]);

        // методы замены
        String newString = langs.replaceAll(", ", " - ");
        System.out.println(newString);

        newString = langs.replaceFirst(", ", " - ");
        System.out.println(newString);

        newString = langs.replace(", ", " - ");
        System.out.println(newString);

        System.out.println(langs.contains(", ")); // проверяет содержит ли строка последовательность символов - true/false
        System.out.println(langs.startsWith("Ja")); // проверяет начинает ли строка с последовательности - true/false
        System.out.println(langs.endsWith("ipt"));// проверяет заканчивается ли строка последовательностью - true/false
        System.out.println(langs.startsWith("Ja",1)); // начинается ли строка начиная с символа под индексом 1 (начинается с 0)
        // все выше регистрозависимые


    }
}
