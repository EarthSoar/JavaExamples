package query;


import java.util.List;

/**
 * @author Willing
 * @date 2019/1/8
 */
public interface IQuery {
    /**
     * 查询条件
     * @return  WHERE ...
     * */
    String getQuery();

    /**
     * 条件中的参数
     * @return
     */
    List<Object> getParameter();
}
