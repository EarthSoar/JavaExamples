package property_place_holder;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DataSourceTest {
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void test() throws Exception {
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
}
