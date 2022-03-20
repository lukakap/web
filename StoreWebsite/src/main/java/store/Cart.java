package store;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;

public class Cart {

    HashMap<Product, Integer> cart;

    public Cart(){
        cart = new HashMap<>();
    }

    public void addElement(Product product, Integer Num){
        if(Num == 0) {
            if(cart.containsKey(product)) cart.remove(product);
        } else {
            cart.put(product, Num);
        }
    }

    public HashMap<Product, Integer> returnCart(){
        return cart;
    }


    public void incrementProductNumber(Product product) {
        if(!cart.containsKey(product)) {
            this.addElement(product,1);
        }else {
            this.addElement(product,cart.get(product)+1);
        }
    }
}

