package jdbc_template.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>>{
	private Class<T> classType = null;
	public BeanListHandler(Class<T> classType){
		this.classType = classType;
	}
	@Override
	public List<T> handle(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		//��������
		//��ȡ����������
		while(rs.next()){
			T obj = classType.newInstance();
			BeanInfo info = Introspector.getBeanInfo(classType,Object.class);
			PropertyDescriptor[] pds = info.getPropertyDescriptors();
			for (PropertyDescriptor ps : pds) {
				//��ȡ���������������������������ͬ�͵���setter������ĳһ�е��������õ�������
				String columnName = ps.getName();
				Object val = rs.getObject(columnName);
				ps.getWriteMethod().invoke(obj, val);
			}
			list.add(obj);
		}
		return list;
	}

}
