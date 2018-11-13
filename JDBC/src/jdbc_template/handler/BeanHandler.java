package jdbc_template.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
/**
 *	�ѱ��е�һ�����ݷ�װһ��������Խ������ֻ��һ�����ݵ����
 * @param <T> 	�淶�����װ�����ֶ���
 */
public class BeanHandler<T> implements IResultSetHandler<T>{
	
	private Class<T> classType = null;
	public BeanHandler(Class<T> classType){
		this.classType = classType;
	}
	@Override
	public T handle(ResultSet rs) throws Exception {
		//������Ӧ��Ķ���
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
