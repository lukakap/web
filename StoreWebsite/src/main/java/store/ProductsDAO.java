package store;

import java.util.List;

public interface ProductsDAO {
    public List<Product> getAll();
    public Product getProductByID(String ID);
}
