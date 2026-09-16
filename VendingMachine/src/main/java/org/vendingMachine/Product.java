package org.vendingMachine;

public class Product {
    private String productName;
    private String productId;
    private int price;

    public Product(String productName, String productId, int price) {
        this.productName = productName;
        this.productId = productId;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }
}
