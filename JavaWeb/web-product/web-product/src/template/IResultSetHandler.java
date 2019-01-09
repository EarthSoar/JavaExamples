package template;

/**
 * @author Willing
 * @date 2019/1/7
 */

import java.sql.ResultSet;

/**
 * 结果集处理器
 * 定义规范
 * @param <T>
 */
public interface IResultSetHandler<T> {
    T handle(ResultSet rs) throws Exception;
}
