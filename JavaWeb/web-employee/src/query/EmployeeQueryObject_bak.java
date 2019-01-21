package query;

import java.util.ArrayList;
import java.util.List;

import util.StringUtil;

public class EmployeeQueryObject_bak {
	private String keyword;
	private java.util.Date minEntryDate;
	private java.util.Date maxEntryDate;

	//封装占位符参数
	private List<Object> parameters = new ArrayList<>();
	//封装查询条件
	private List<String> conditions = new ArrayList<>(); 
	public String getQuery() {
		if(StringUtil.hasLength(keyword)) {  //keyword LIKE ?
			conditions.add("keyword LIKE ? ");
			parameters.add("%" + keyword + "%");
		}
		if(minEntryDate != null) {
			conditions.add("entryDate >= ?");
			parameters.add(minEntryDate);
		}
		if(maxEntryDate != null) {
			conditions.add("entryDate <= ?");
			parameters.add(maxEntryDate);
		}
		//拼接SQL
		StringBuilder sql = new StringBuilder();
		for (int i = 0; i < conditions.size(); i++) {
			if( i == 0) {
				sql.append(" WHERE ");
			}else {
				sql.append(" AND ");
			}
			sql.append(conditions.get(i));
		}
		return sql.toString();
	}
	//获取参数
	public List<Object> getParameters() {
		return parameters;
	}

	//====================
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public java.util.Date getMinEntryDate() {
		return minEntryDate;
	}
	public void setMinEntryDate(java.util.Date minEntryDate) {
		this.minEntryDate = minEntryDate;
	}
	public java.util.Date getMaxEntryDate() {
		return maxEntryDate;
	}
	public void setMaxEntryDate(java.util.Date maxEntryDate) {
		this.maxEntryDate = maxEntryDate;
	}
	
}
