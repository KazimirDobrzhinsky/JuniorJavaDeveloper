package ru.itmo.lessons.lesson6.homeworkTask01;

import ru.itmo.lessons.lesson6.homeworkTask01.products.Product;
import ru.itmo.lessons.lesson6.homeworkTask01.products.MyProduct;

public class Application {

    public static void main(String[] args) {


        Product product1 = new Product("Sugar", 10, 10, 10, 1000);
        Product product2 = new Product("Wine");
        product2.setProteinAmount(103);
        product2.setFatAmount(100);
        product2.setCarbonAmount(6);
        product2.setCaloriesAmount(78);
        Product product3 = new Product("Sushi", 9, 5, 10, 10);
        Product product4 = new Product("Pizza", 1.056, 1.06, 10, 1.066);

        MyProduct myProduct = new MyProduct();


        myProduct.addProduct(product1);
        myProduct.addProduct(product2);
        myProduct.addProduct(product3);
        myProduct.addProduct(product4);

        myProduct.printProductListNames();





    }

}
