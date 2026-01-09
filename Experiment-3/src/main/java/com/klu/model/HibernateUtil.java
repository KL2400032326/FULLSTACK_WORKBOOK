package com.klu.model;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
private static SessionFactory factory;
static {
	factory=new Configuration()
			.configure("Hql.cfg.xml")
			.buildSessionFactory();
}
public static SessionFactory getSessionFactory() {
return factory;
}
}
