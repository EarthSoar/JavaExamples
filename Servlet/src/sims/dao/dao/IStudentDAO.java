package dao.dao;


import java.util.List;

import dao.daomain.Student;

/**
 * @author 15626
 *	CRUD操作
 */
public interface IStudentDAO {
	
	/**保存指定的学生对象
	 * @param stu	需要保存的学生对象
	 */
	void save(Student stu);
	
	/**根据id删除学生
	 * @param id
	 */
	void delete(Long id);

	/**更改指定的学生对象
	 * @param newStu 新的学生对象
	 */
	void update(Student newStu);
	
	 /**
	  *	查找一个学生的信息
	 * @param id	学生的id
	 * @return	如果存在返回学生对象，不存在则返回null
	 */
	Student get(Long id);
	
	/**查询所有学生的信息
	 * @return	返回学生集合，不存在返回空集
	 */
	List<Student> list();
}
