package org.academy.object.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateDB {
    /** create the db properties **/
	static SessionFactory sessionFactory;
	static {
		AnnotationConfiguration cfg=new AnnotationConfiguration();
		cfg=(AnnotationConfiguration)cfg.configure();
		sessionFactory=cfg.buildSessionFactory();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
