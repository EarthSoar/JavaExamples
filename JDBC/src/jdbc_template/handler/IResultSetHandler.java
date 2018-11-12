package jdbc_template.handler;

import java.sql.ResultSet;

/**
 * @author 15626
 *	
 */
public interface IResultSetHandler<T> {
	T handle(ResultSet rs) throws Exception;
}
