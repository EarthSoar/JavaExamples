package query;

import java.util.List;

/**
 * 	所有查询对象所要遵循的规范
 * @author Willing
 *
 */
public interface IQuery {
	/**
	 * @return 查询的条件
	 */
	String getQuery();
	
	/**
	 * @return 查询条件中的参数
	 */
	List<Object> getParameters();
}
