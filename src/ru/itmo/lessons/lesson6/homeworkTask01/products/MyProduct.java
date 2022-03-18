package ru.itmo.lessons.lesson6.homeworkTask01.products;

public class MyProduct {
    final double maxProteinAmount = 150;
    final double maxFatAmount = 50;
    final double maxCarbonAmount = 90;
    final double maxCaloriesAmount = 1300;
    public Product[] productList = new Product[10];

    public void addProduct(Product product) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] == null) {
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
