package test;

import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import daomain.Product;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Willing
 * @date 2018/12/18
 */
public class IProductDAOTest {
    IProductDAO dao = new ProductDAOImpl();
    @Test
    public void save() throws Exception {
        dao.save(new Product("HHH11", "HHH","HHH" , new BigDecimal(200), new BigDecimal(200), 0.1,1L));
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void get() throws Exception {
        Product p = dao.get(2L);
        System.out.println(p);
    }

    @Test
    public void list() throws Exception {
//        //List<Product> list = dao.list();
//        for (Object list1:  list) {
//            System.out.println(list1);
//        }
    }
}