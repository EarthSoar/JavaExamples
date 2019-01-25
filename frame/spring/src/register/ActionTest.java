package register;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import register.action.UserAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ActionTest {
	
	@Autowired
	private UserAction action;
	
	@Test
	public void testAction() throws Exception {
		action.execute();
	}
}
