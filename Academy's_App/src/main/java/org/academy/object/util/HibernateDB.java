package org.academy.object.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



public class HibernateDB {
    /** create the db properties **/
	public static SessionFactory sessionFactory;
	
  /* static {
		
		AnnotationConfiguration cfg=new AnnotationConfiguration();
		cfg=(AnnotationConfiguration)cfg.configure();
		sessionFactory=cfg.buildSessionFactory();
	} */

	public static SessionFactory getSessionFactory() {
		AnnotationConfiguration cfg=new AnnotationConfiguration();
		AnnotationConfiguration	cfg1=(AnnotationConfiguration)cfg.configure();
		sessionFactory=cfg1.buildSessionFactory();
		return sessionFactory;
	}
	
}
