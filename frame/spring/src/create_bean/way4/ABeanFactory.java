package create_bean.way4;

import org.springframework.beans.factory.FactoryBean;

public class ABeanFactory implements FactoryBean<ABean> {

	@Override
	public ABean getObject() throws Exception {
		return new ABean();
	}

	@Override
	public Class<?> getObjectType() {
		return ABean.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
