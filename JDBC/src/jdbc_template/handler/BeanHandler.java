package jdbc_template.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
/**
 *	把表中的一行数据封装一个对象，针对结果集中只有一行数据的情况
 * @param <T> 	规范具体封装成那种对象
 */
public class BeanHandler<T> implements IResultSetHandler<T>{
	
	private Class<T> classType = null;
	public BeanHandler(Class<T> classType){
		this.classType = classType;
	}
	@Override
	public T handle(ResultSet rs) throws Exception {
		//创建对应类的对象
		T obj = classType.newInstance();
		if(rs.next()){
			BeanInfo info = Introspector.getBeanInfo(classType,Object.class);
			PropertyDescriptor[] pds = info.getPropertyDescriptors();
			for (PropertyDescriptor ps : pds) {
				String column = ps.getName();
				Object val = rs.getObject(column);
				ps.getWriteMethod().invoke(obj,val);
			}
		}
		return obj;
	}
}
