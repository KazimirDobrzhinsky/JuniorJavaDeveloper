package lesson1;

public class HomeWorkFirstLesson {
    public static void main(String[] args) {

        // Задача на тернарный оператор:

        float sum = 9999f;
        float res = (sum > 100000) ? (sum * 0.9f) : sum;
        System.out.println(res);

        // Задача на арифметические! операторы:

        int x = 55;
        int res2 = (x / 10) + (x % 10);
        System.out.println(res2);

        // Задача на арифметические операторы:

        double length = 10.3, breadth = 13, height = 45.63;
        double res3 = 2 * (length * breadth + breadth * height + length * height);
        System.out.println(res3);
    }
}
