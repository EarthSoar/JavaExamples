### 一、Hibernate-CRUD操作

目录结构：

![img](https://s2.ax1x.com/2019/01/23/kAsr9K.png) 

#### 1.创建domain

```java
public class User {
	private Long id;
	private String name;
	private BigDecimal salary;
	private java.util.Date hiredate;
    //getter,setter
}
```

#### 2.DAO

```java
public interface IUserDAO {
	void save(User user);

	void delete(User user);

	void update(User user);

	User get(Long id);

	List<User> list();
}
```

#### 3.User.hbm.xml配置

> - package是可以不写的,如果不写package,其中所有的类都必须有全限定名.
> - 在一个hbm.xml中,可以写多个对象的映射,但是一般来说,一个映射文件对应一个对象.建议和类名相同(User.java --> User.hbm.xml)
> - class元素的table属性是可以省略的,如果不写table,对应table的名称和类的名称一模一样(大小写一样).
> - property元素对应的是对象的属性,而不是字段,可以通过修改property元素的access属性来改变访问策略(访问属性/字段).<property. name="bornDate" access="field"/>使用字段来关联表字段
> 	 property元素的type属性可以为对象的属性添加指定的映射类型type里面写的类型,不是数据库的类型,是hibernate定义的一种中间类型,	JAVA类型-中间类型-数据表类型

```xml
<hibernate-mapping package="hello.domain">
	<class name="User" table="t_user">
		<id name="id" column="uid">
			<generator class="native"></generator>
		</id>
		<property name="name" column="uname"/>
		<property name="salary" column="usalary"/>
	</class>
</hibernate-mapping>
```

#### 4.hibernate.cfg.xml或者hibernate.properties

```properties
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.connection.driver_class=com.mysql.jdbc.Driver
hibernate.connection.url=jdbc:mysql:///demo
hibernate.connection.username=root
hibernate.connection.password=admin
#自动生成数据库表
hibernate.hbm2ddl.auto=create
```

把所有连接数据库的配置放在hibernate.properties文件中,在hibernate.cfg.xml文件中 只存在关联映射的配置

或者是把所有的连接数据库的配置放在  hibernate.cfg.xml文件中 

```xml
<hibernate-configuration>
	<session-factory>
		<!-- 连接数据库所需要的五要素 -->
		<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>		
		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="hibernate.connection.url">jdbc:mysql:///demo</property>
		<property name="hibernate.connection.username">root</property>
		<property name="hibernate.connection.password">admin</property>
		<property name="hibernate.show_sql">true</property>
		<!-- 关联需要管理的映射文件 -->  
		<mapping resource="hello/domain/User.hbm.xml"/>
	</session-factory>
</hibernate-configuration>
```

#### 5.DAO实现类

```java
@SuppressWarnings("all")
public class UserDAOImpl implements IUserDAO {
	@Override
	@SuppressWarnings("all")
	public void save(User user) {
		// 1.创建配置对象,读取配置文件
		Configuration config = new Configuration().configure();
		// 2.获取SessionFactory对象
		SessionFactory sf = config.buildSessionFactory();
		// 3.获取Session对象
		Session session = sf.openSession();
		// 4.激活事务
		Transaction tx = session.beginTransaction();
		// 5.具体操作(DML语句)
		session.save(user);// INSERT INTO 表名
		// 6.提交事务
		session.getTransaction().commit();
		// 7.关闭session
		session.close();
		// 8.关闭SessionFactory
		sf.close();
	}

	@Override
	public void delete(User user) {
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	@Override
	public void update(User user) {
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	@Override
	public User get(Long id) {
		// 1.创建配置对象
		Configuration config = new Configuration();
		// 2.读取配置文件
		config.configure("/hibernate.cfg.xml");
		// 3.创建SessionFactory.
		@SuppressWarnings("deprecation")
		SessionFactory sf = config.buildSessionFactory();
		// 4.获取Session
		Session session = sf.openSession();
		// 5.具体的查询操作 SELECT * FROM 表名 WHERE id = ?
		User user = (User) session.get(User.class, id);
		// 6.关闭session
		session.close();
		// 7.关闭SessionFactory
		sf.close();

		return user;
	}

	@Override
	@SuppressWarnings("all")
	public List<User> list() {
		// 1.创建配置对象读取配置文件
		Configuration config = new Configuration().configure();
		// 2.创建SessionFactory对象
		SessionFactory sf = config.buildSessionFactory();
		// 获取Session对象
		Session session = sf.openSession();
		// 查询操作
		String hql = "SELECT u FROM User u";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		// 关闭session
		session.close();
		sf.close();
		return list;
	}
}
```

#### 6.测试

### 二、配置和映射文件细节

#### 自动生成数据库表

根据对象和和映射文件，在创建SessionFactory对象的时候，可以自动生成对应的数据库表
在hibernate.properties配置文件中`hibernate.hbm2ddl.auto`属性

|   属性值    |                          描述                           |
| :---------: | :-----------------------------------------------------: |
| create-drop |    删除表后创建表，在SessionFactory关闭后再次删除表     |
|   create    |                     先删除后创建表                      |
|   update    |         匹配domain属性和数据库表的列,更新表结构         |
|  validate   | 验证表结构:如果表结构和映射文件不匹配,hibernate启动失败 |

其中所说的表指的是被hibernate所管理的表，添加一个domain或者属性hibernate会创建对应的表或者更新所在列，但是删除属性或者domain后hibernate不做处理。

### 三、OID

OID在Hibernate中唯一标识了一个对象,在一级缓存中,Type+OID唯一标识了一级缓存中相同的数据,一般情况,在domain当中,需要用OID属性来重写equals和hashcode法方法,id元素都有一个generator子元素,规定了主键的生成策略.

```xml
<id name="id" column="uid">
	<generator class="native"></generator>
</id>
```

#### 1.自然主键

assigned，在保存之前，必须要手动设置值，assigned针对的是自然主键。与Hibernate和底层数据库都无关，可以跨数据库。在存储对象前，必须要使用主键的setter方法给主键赋值，至于这个值怎么生成，完全由自己决定。

#### 2.代理主键

主键的值是由数据库或者hibernate来自动生成的

- uuid  使用uuid作为主键值 ,要求类型必须是String的
- increment：由hibernate来生成主键，先查询当前表的id最大值，然后给最大值加上1作为当前主键值，要求主键类型可以递增，并且不能在集群(多个hibernate实例使用同一个数据库)的情况下使用。
- identity：数据库来生成id，mysql数据库auto_increment  ,oracle不支持id生成策略所有不能使用
- native： 使用数据库本地生成策略

**主键生成策略详细：**https://www.cnblogs.com/hoobey/p/5508992.html

### 四、Session中的方法

#### 1.常用方法

```java
Transaction beginTransaction():设置事务的活动状态.
Transaction getTransaction():获取一个事务
Serializable save(Object o):保存一个对象
void update(Object o):修改一个对象
void delete(Object o):删除一个对象
Object get(Class type,Serializable id):根据主键查询指定类型的对象
Query createQuery(String hql):根据hql创建一个查询对象
void close():关闭Session
void clear():清除一级缓存所有对象
void evict(Object o):清除一级缓存中制定的对象
```

#### 2.save方法和persist方法

persist和方法save方法都表示保存一个对象,但是persist方法必须运行在事务空间内，save方法在没有事务的环境也会发送sql，persist方法则不会发送 sql

#### 3.get和load方法

- 发送SQL的时机不同. get:立刻发送.load:使用该对象的非OID属性,才发送.(延迟加载)
- 返回结果是否为null.   get:如果OID存在,则返回不为null,否则返回null.      load:因为返回的是一个代理对象,永远不为null.  如果OID不存在会报错
- 是否创建代理对象:     get:不会     load:创建

```java
	@Before
	public void testSave() {
		User user = new User();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();//设置事务活动状态
		/**
		 * 在没有事务的环境下save还会发送sql,persist不会发送sql  保存对象一定要在事务的环境下才可以成功
		 * persist是为了时下JPA规范 
		 */
		session.save(user);
		//session.persist(user);
		session.getTransaction().commit();//提交事务
		session.close();
	}
	
	@Test
	public void testGet() {
		Session session = HibernateUtil.getSession();
		System.out.println("----");
		/**
		 * get方法：数据库存在返回的user不为null,反之返回 null。并且会立刻发出sql
		 */
		//User user = (User) session.get(User.class, 2L);
		
		/**
		 * load方法: 返回的user对象始终不为null,并且 在使用费OID属性的时候才会发出sql语句 
		 *	创建了代理对象 User_$$_jvst42_0 .所以始终返回的不是null
		 */
		User user = (User) session.load(User.class, 1L);
		System.out.println("----");
		if(user == null) {
			System.out.println("user为null");
		}else {
			System.out.println("user不为null");
		}
		System.out.println(user.getClass());//class hello.domain.User_$$_jvst42_0  --load
		user.getName();//load方法在使用非OID属性的时候才发出sql
		session.close();
	}
```

### 五、持久化对象的生命周期和对象的状态

![img](https://s2.ax1x.com/2019/01/23/kAsbuQ.png) 

#### 1.临时状态

特点：没有OID，没有被session管理

- 对象刚刚被new出来，没有OID也没有在一级缓存中(没有被session所管理)
- 处于删除状态的对象，在提交事务之后，对象也处于临时状态

#### 2.删除状态

特点: 有OID，也被session所管理，但是最终会被删除。删除状态的对象必须等到session刷新flush，事务提交的时候才真正被删除。

- delete方法让处于持久化状态的对象或者处于游离状态的对象转化为删除状态。

```java
public void test() {
    User user = new User();//刚被 new出来 处于临时状态
    user.setName("giao");//设置的是非OID属性,属性并没有OID,依然处于临时状态
    user.setId(1L);//属性有了OID,此时 处于 游离状态

    Session session = HibernateUtil.getSession();
    session.beginTransaction();//设置事务活动状态
    /**
	*情况1.session.delete(user);//删除处于游离状态的属性,属性进入删除状态
	 * 
	*情况2.先  session.get(user)使得对象处于持久化状态 
	*	 后调用session.delete(user);对象进入了删除状态 
	*/
    System.out.println(user.getId());//还存在OID,在事务提交后才会真正的从数据库删除

    session.getTransaction().commit();//提交事务
    session.close();
}
```

#### 3.持久化状态

特点:对象具有OID值，也在一级缓存中，被session管理

- save方法把临时状态转换为持久化状态
- save方法把游离对象变成另一个持久化状态,创建一个新的session
- get和load方法返回的是持久化对象.
- Query.list方法返回的是持久化对象
- update方法把游离对象变成持久化对象

#### 4.游离状态（托管状态）

特点：有OID,但是不被session管理，不在一级缓存中

- closed、clear方法把所有处于持久化状态的对象变成游离状态 
- 处于临时状态的对象设置OID属性后变成游离状态

------

默认情况下，在事务提交时，会自动去数据库同步这一次对象发送状态变化并且发送sql语句

- 临时状态变成持久化状态发送INSERT 语句
- 持久化或者游离状态变成删除状态发送的是DELETE语句
- 游离状态变成 持久化状态发送INSERT或者UPDATE
- 在事务环境下,通过get方法得到的对象,只要修改了属性值,会发生UPDATE语句.  在事务提交的时候检查一级缓存中的数据和快照区域是否相同，如果不同(脏数据)，把一级缓存中的数据同步到数据库发送的是UPDATE语句

**总结：**session中的方法改变的是对象的状态与sql的发送没有关系，在事务提交的时候同步数据库的数据（发送SQL语句）