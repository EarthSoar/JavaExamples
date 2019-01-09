package test;

import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import daomain.Product;
import org.junit.Test;
import page.PageResult;
import query.ProductQueryObject;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Willing
 * @date 2019/1/8
 */
public class QueryTest {
    ProductQueryObject queryObject = new ProductQueryObject();
    IProductDAO dao = new ProductDAOImpl();
    @Test
    public void testQuery(){
        queryObject.setProductName("M");
        List<Product> products = dao.list(queryObject);
        System.out.println(products);
    }
    @Test
    public void testPage(){
        //queryObject.setCurrentPage(1);
        //queryObject.setPageSize(5);
        queryObject.setCurrentPage(2);
        queryObject.setMinSalePrice(new BigDecimal(100));//设置条件
        queryObject.setMaxSalePrice(new BigDecimal(200));
        PageResult pageResult = dao.query(queryObject);
        System.out.println("当前页: " + pageResult.getCurrentPage());
        System.out.println("总条数：" + pageResult.getTotalCount());;
        System.out.println("总页数: " + pageResult.getTotalPage());
        List res = pageResult.getListData();
        for (Object o:
             res) {
            System.out.println(o);
        }
    }
}
