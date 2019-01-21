package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryObject {
	// 封装占位符参数
	private List<Object> parameters = new ArrayList<>();
	// 封装查询条件
	private List<String> conditions = new ArrayList<>();

	private Integer currentPage = 1;
	private Integer pageSize = 3;
	
	public String getQuery() {
		this.customizedQuery();
		// 拼接SQL
		StringBuilder sql = new StringBuilder();
		for (int i = 0; i < conditions.size(); i++) {
			if (i == 0) {
				sql.append(" WHERE ");
			} else {
				sql.append(" AND ");
			}
			sql.append(conditions.get(i));
		}
		return sql.toString();
	}

	// 暴露给子类定制查询
	protected void customizedQuery() {

	}

	//添加查询查询条件和参数
	protected void addQuery(String condition, Object... params) {
		conditions.add(condition);
		parameters.addAll(Arrays.asList(params));
	}

	// 获取参数
	public List<Object> getParameters() {
		return parameters;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
