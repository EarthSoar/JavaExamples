package web.servlet;

import dao.IProductDAO;
import dao.IProductDirDAO;
import dao.impl.ProductDAOImpl;
import dao.impl.ProductDirImpl;
import daomain.Product;
import page.PageResult;
import query.ProductQueryObject;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author Willing
 * @date 2019/1/8
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private IProductDAO dao;
    private IProductDirDAO dirDAO;
    @Override
    public void init() throws ServletException {
        dao = new ProductDAOImpl();
        dirDAO = new ProductDirImpl();
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在程序的开始设置编码为utf-8
        req.setCharacterEncoding("utf-8");
        //实现分发操作
        String cmd = req.getParameter("cmd");
        if("save".equals(cmd)){
            this.save(req,resp);
        }else if("delete".equals(cmd)){
            this.delete(req,resp);
        }else if("edit".equals(cmd)){
            this.edit(req,resp);
        }else{
            this.list(req,resp);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求参数
        String productName = req.getParameter("productName");
        String minSalePrice = req.getParameter("minSalePrice");
        String maxSalePrice = req.getParameter("maxSalePrice");
        String dirId = req.getParameter("dirId");
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        //把参数封装成查询对象
        ProductQueryObject queryObject = new ProductQueryObject();
        if(StringUtil.hasLength(productName)){
            queryObject.setProductName(productName);
        }
        if(StringUtil.hasLength(minSalePrice)){
            queryObject.setMinSalePrice(new BigDecimal(minSalePrice));
        }
        if(StringUtil.hasLength(maxSalePrice)){
            queryObject.setMaxSalePrice(new BigDecimal(maxSalePrice));
        }
        if(StringUtil.hasLength(dirId)){
            queryObject.setDirId(Long.valueOf(dirId));
        }
        if(StringUtil.hasLength(currentPage)){
            queryObject.setCurrentPage(Integer.valueOf(currentPage));
        }
        if (StringUtil.hasLength(pageSize)) {
            queryObject.setPageSize(Integer.valueOf(pageSize));
        }

        //处理请求

        //===========
//        List<Product> list = dao.list(queryObject);
//        req.setAttribute("list",list);//把数据设置在作用域对象中
        //===========
        PageResult pageResult = dao.query(queryObject);
        req.setAttribute("pageResult",pageResult);
        req.setAttribute("qo",queryObject);//用于回显数据
        req.setAttribute("dirs",dirDAO.list());
        //控制页面跳转,需要共享数据所以选用请求转发
        req.getRequestDispatcher("/WEB-INF/product/list.jsp").forward(req,resp);
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //编辑操作,保存和修改都要调用，二者的区别是保存没有id,需要需要id
        String sid = req.getParameter("id");
        if(StringUtil.hasLength(sid)){//修改操作
            Long id = Long.valueOf(sid);
            Product pro = dao.get(id);//回显数据
            req.setAttribute("pro",pro);
        }
        req.setAttribute("dirs",dirDAO.list());
        req.getRequestDispatcher("/WEB-INF/product/edit.jsp").forward(req,resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //接受请求参数
        String sid = req.getParameter("id");
        Long id = Long.valueOf(sid);
        //处理请求
        dao.delete(id);
        //控制页面跳转,不需要共享数据,选用 重定向
        resp.sendRedirect("/product");
    }

    protected void save(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //接受请求参数,封装成对象
        Product p = new Product();
        p.setSupplier(req.getParameter("supplier"));
        p.setProductName(req.getParameter("productName"));
        p.setDir_id(Long.valueOf(req.getParameter("dir_id")));
        p.setCutoff(Double.valueOf(req.getParameter("cutoff")));
        p.setBrand(req.getParameter("brand"));
        p.setSalePrice(new BigDecimal(req.getParameter("salePrice")));
        p.setCostPrice(new BigDecimal(req.getParameter("costPrice")));
        //处理请求
        //保存和修改都要调用，二者的区别是保存没有id,需要需要id
        String sid = req.getParameter("id");
        if (StringUtil.hasLength(sid)){
            Long id = Long.valueOf(sid);
            p.setId(id);
            dao.update(p);
        } else {
            dao.save(p);
        }
        //控制页面跳转
        resp.sendRedirect("/product");//跳到首页
    }}
