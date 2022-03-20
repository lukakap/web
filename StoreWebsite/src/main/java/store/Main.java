package store;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart();
        Product prod1 = new Product("CHK","Maisuri","image",15.00);
        Product prod2 = new Product("CHK","maisuri","image",15.00);
        Product prod4 = new Product("CHK","maisuri","image",15.00);
        Product prod3 = new Product("KLP","sharvali","image",25.00);
        cart.addElement(prod1,1);
        cart.addElement(prod2,2);
        cart.addElement(prod3,1);
        cart.addElement(prod4,5);
        HashMap<Product,Integer> cartT = cart.returnCart();
        for(Product key : cartT.keySet()) {
            printChem(key,cartT.get(key));
        }
    }

    private static void printChem(Product key, Integer value) {
        double d = 2.5;
        System.out.println("key: " + key);
        System.out.println("Value" + value);
    }
}
