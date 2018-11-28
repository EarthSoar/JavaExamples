package dao.dao;


import java.util.List;

import dao.daomain.Student;

/**
 * @author 15626
 *	CRUD����
 */
public interface IStudentDAO {
	
	/**����ָ����ѧ������
	 * @param stu	��Ҫ�����ѧ������
	 */
	void save(Student stu);
	
	/**����idɾ��ѧ��
	 * @param id
	 */
	void delete(Long id);

	/**����ָ����ѧ������
	 * @param newStu �µ�ѧ������
	 */
	void update(Student newStu);
	
	 /**
	  *	����һ��ѧ������Ϣ
	 * @param id	ѧ����id
	 * @return	������ڷ���ѧ�����󣬲������򷵻�null
	 */
	Student get(Long id);
	
	/**��ѯ����ѧ������Ϣ
	 * @return	����ѧ�����ϣ������ڷ��ؿռ�
	 */
	List<Student> list();
}
