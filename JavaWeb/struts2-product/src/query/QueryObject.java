package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 所有查询对象的基类
 * 
 * @author Willing
 *
 */
public class QueryObject implements IQuery {

	// 封装查询的参数
	private List<Object> param = new ArrayList<>();
	// 封装查询的条件
	private List<Object> condition = new ArrayList<>();

	//封装排序规则和参数："salaPrice",OrderBy.DESC,为了保证顺序需使用LinkedHashMap
	private Map<String,String> orderByMap = new LinkedHashMap<>();
	@Override
	public String getQuery() {
		StringBuilder sql = new StringBuilder(80);

		// 定制自身查询信息
		this.customizedQuery();

		for (int i = 0; i < condition.size(); i++) {
			if (i == 0) {
				sql.append(" WHERE ");
			} else {
				sql.append(" AND ");
			}
			sql.append(condition.get(i));
		}
		
		//拼接排序SQL
//		if(orderByMap.size() > 0) {
//			sql.append(" ORDER BY ");
//			Set<Entry<String,String>> entrySet = orderByMap.entrySet();
//			for (Entry<String, String> entry : entrySet) {
//				String columnName = entry.getKey();
//				String type = entry.getValue();
//				sql.append(columnName).append(" ").append(type).append(",");
//			}
//			sql.deleteCharAt(sql.length() - 1);
//		}
		return sql.toString();
	}

	//暴露给子类，让子类定制查询的信息
	protected void customizedQuery() {
		
	}
	
	//添加查询查询条件和参数
	protected void addQuery(String conditions,Object...params) {
		condition.add("("+conditions+")");
		param.addAll(Arrays.asList(params));
	}
	protected void setOrderBy(String columnName,OrderBy ascOrDesc) {
		orderByMap.put(columnName, ascOrDesc.name());
	}
	
	//两个排序的顺序
	enum OrderBy{
		ASC,DESC
	}
	@Override
	public List<Object> getParameters() {
		return this.param;
	}

}
