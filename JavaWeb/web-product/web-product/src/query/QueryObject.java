package query;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Willing
 * @date 2019/1/8
 */
@Data
public class QueryObject implements IQuery{
    //封装查询条件中的参数
    private List<Object> params = new ArrayList<Object>();
    //封装查询条件
    private List<Object> conditions = new ArrayList<Object>();


    //分页查询需要的当前页,页面展示的数据条数
    private Integer currentPage = 1;
    private Integer pageSize = 4;
    /**
     * 获取查询条件   WHERE ...  如 WHERE productName = '%M%';
     * @return
     */
    public String getQuery(){
        StringBuilder sql = new StringBuilder(80);

        this.customizedQuery();
        for(int i = 0; i < conditions.size(); i++){
            if(i == 0){
                sql.append(" WHERE ");
            }else{
                sql.append(" AND ");
            }
            sql.append(conditions.get(i));
        }
        return sql.toString();
    }


    protected void customizedQuery(){
        //子类定制自己的查询信息
    }

    //增添查询条件和参数
    protected void addQuery(String condition,Object...param){
        conditions.add(condition);
        params.addAll(Arrays.asList(param));
    }
    public List<Object> getParameter(){
        return this.params;
    }
}
