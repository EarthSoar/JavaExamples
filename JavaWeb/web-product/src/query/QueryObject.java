package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	@Override
	public List<Object> getParameters() {
		return this.param;
	}

}
