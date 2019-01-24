package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory sf;
	static {
		Configuration config = new Configuration().configure();
		sf = config.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session = sf.openSession();
		return session;
	}
}
