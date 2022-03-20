package store;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class sqlProductsDAO implements ProductsDAO{
    DataSource dataSource;
    private String getAllRequest = "select * from products";
    private String getByIdRequest = "select * from products Where productid = ";

    public sqlProductsDAO(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/forProducts");
        dataSource.setUsername("root");
        dataSource.setPassword("lukakapa1213");

        this.dataSource = dataSource;


    }



    @Override
    public List<Product> getAll() {
        return getListFromBase(getAllRequest);
    }


    private ArrayList<Product> getListFromBase(String request) {
        ArrayList<Product> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(request);
            while (result.next()){
                list.add(convertToProduct(result));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;

    }

    private Product convertToProduct(ResultSet result) {
        Product product = null;
        try {
            String id = result.getString("productid");
            String name = result.getString("name");
            String url = result.getString("imagefile");
            double price = result.getDouble("price");
            product = new Product(id,name,url,price);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return product;
    }


    @Override
    public Product getProductByID(String ID) {
        char mark = '"';
        String request = getByIdRequest + mark + ID + mark;
        return getListFromBase(request).get(0);
    }

}
