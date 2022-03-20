package store;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class sqlProductsDAOTest {

    @Test
    public void test1(){
        String actual = "Classic Hoodie" + "Limited Edition Hood" + "Classic Tee" + "Seal Tee"+"Japanese Tee"+"Korean Tee"+"Chinese Tee"+"Hindi Tee"+"Arabic Tee"+"Hebrew Tee"+"Keychain"+"Lanyard"+"Thermos"+"Mini Football Helmet";
        sqlProductsDAO dao = new sqlProductsDAO();
        ArrayList<Product> products = (ArrayList<Product>) dao.getAll();
        String returnStr = "";
        for(Product product: products) {
            returnStr += product.getName();
        }
        assertEquals(returnStr,actual);
    }

    @Test
    public void test2(){
        sqlProductsDAO dao = new sqlProductsDAO();
        ArrayList<Product> products = (ArrayList<Product>) dao.getAll();
        assertEquals(products.get(0).getProductID(),"HC");
        assertEquals(products.get(3).getProductID(),"TS");
        assertEquals(products.get(10).getProductID(),"AKy");
        assertEquals(products.get(1).getPrice(),54.95,0);
        assertEquals(products.get(5).getPrice(),17.95,0);
        assertEquals(products.get(4).getImageFile(),"JapaneseTShirt.jpg");
        assertEquals(products.get(8).getImageFile(),"ArabicTShirt.jpg");
    }

    @Test
    public void test3(){
        sqlProductsDAO dao = new sqlProductsDAO();
        assertEquals(dao.getProductByID("AMinHm").getName(),"Mini Football Helmet");
        assertEquals(dao.getProductByID("AMinHm").getPrice(),29.95,0);
        assertEquals(dao.getProductByID("AKy").getName(),"Keychain");
        assertEquals(dao.getProductByID("TLAr").getName(),"Arabic Tee");
        assertEquals(dao.getProductByID("TLCh").getName(),"Chinese Tee");
    }
}