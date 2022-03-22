package ru.itmo.lessons.lesson6.homeworkTask02.products;

public class Product {
    private String productName;
    private double proteinAmount;
    private double fatAmount;
    private double carbonAmount;
    private double caloriesAmount;


    public Product() {

    }

    public Product(String productName) {
        setProductName(productName);
    }

    public Product(String productName, double proteinAmount, double fatAmount, double carbonAmount) {
        this(productName);
        setProteinAmount(proteinAmount);
        setFatAmount(fatAmount);
        setCarbonAmount(carbonAmount);
    }

    public Product(String productName, double proteinAmount, double fatAmount, double carbonAmount, double caloriesAmount) {
        this(productName, proteinAmount, fatAmount, carbonAmount);
        setCaloriesAmount(caloriesAmount);
    }

    public String getProductName() {
        return productName;
    }

    public double getProteinAmount() {
        return proteinAmount;
    }

    public double getFatAmount() {
        return fatAmount;
    }

    public double getCarbonAmount() {
        return carbonAmount;
    }

    public double getCaloriesAmount() {
        return caloriesAmount;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.length() < 2 || productName.startsWith(" ") || productName.endsWith(" "))
            throw new IllegalArgumentException("Название продуктов не может быть null или короче 2х символов или начинатся/заканчиваться пробелом");
        this.productName = productName;
    }

    public void setProteinAmount(double proteinAmount) {
        if (proteinAmount <= 0)
            throw new IllegalArgumentException("Кол-во протеина не может быть меньше или равно нулю");
        this.proteinAmount = proteinAmount;
    }

    public void setFatAmount(double fatAmount) {
        if (fatAmount <= 0)
            throw new IllegalArgumentException("Кол-во жира не может быть меньше или равно нулю");
        this.fatAmount = fatAmount;
    }

    public void setCarbonAmount(double carbonAmount) {
        if (carbonAmount <= 0)
            throw new IllegalArgumentException("Кол-во углеводов не может быть меньше или равно нулю");
        this.carbonAmount = carbonAmount;
    }

    public void setCaloriesAmount(double caloriesAmount) {
        if (caloriesAmount <= 0)
            throw new IllegalArgumentException("Кол-во калорий не может быть меньше или равно нулю");
        this.caloriesAmount = caloriesAmount;
    }
}

