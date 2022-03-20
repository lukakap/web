package store;

import java.util.Objects;

public class Product {

    private String productID;
    private String name;
    private String imageFile;
    private double price;

    public Product(String productID, String name, String imageFile, double price){
        this.productID = productID;
        this.name = name;
        this.imageFile = imageFile;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getImageFile() {
        return imageFile;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(productID, product.productID) && Objects.equals(name, product.name) && Objects.equals(imageFile, product.imageFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, imageFile, price);
    }
}
