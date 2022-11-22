package org.academy.object.util;

import org.hibernate.cfg.Configuration;

public class Hconfiguration {

	public static void getHconfig() {
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
	}
}
