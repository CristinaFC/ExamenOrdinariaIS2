package model;


public class Bid {
    
    private Double price;
    private String productName;

    public Bid(Double price, String productName) {
        this.price = price;
        this.productName = productName;
    }

    public Double price() {
        return price;
    }

    public String productName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Bid{" + "price=" + price + ", productName=" + productName + '}';
    }
    
}
