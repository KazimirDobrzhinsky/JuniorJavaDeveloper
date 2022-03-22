package ru.itmo.lessons.lesson6.homeworkTask02.products;

public class MyProduct {
    final private double maxProteinAmount = 150;
    final private double maxFatAmount = 50;
    final private double maxCarbonAmount = 90;
    final private double maxCaloriesAmount = 1300;
    private final Product[] productList = new Product[10];

    public void addProduct(Product product) {
        if (product.getProteinAmount() > maxProteinAmount) {
            System.out.println("Слишком много протеина");
            return;
        }
        if (product.getFatAmount() > maxFatAmount) {
            System.out.println("Слишком много жира");
            return;
        }
        if (product.getCarbonAmount() > maxCarbonAmount) {
            System.out.println("Слишком много углеводов");
            return;
        }
        if (product.getCaloriesAmount() > maxCaloriesAmount) {
            System.out.println("Слишком много калорий");
            return;
        }
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] == null) {
                productList[i] = product;
                return;
            }
        }
       System.out.println("Нет места");
    }

    public void printProductListNames() {
        for (Product productList: productList) {
            if (productList != null) {
                System.out.println(productList.getProductName());
            }

        }

    }

}
