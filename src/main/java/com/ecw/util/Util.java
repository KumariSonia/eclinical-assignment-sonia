package com.ecw.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ecw.model.Address;
import com.ecw.model.Category;
import com.ecw.model.OrderDetail;
import com.ecw.model.Product;
import com.ecw.model.User;
import com.ecw.model.UserTyppe;

public class Util {
	static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Product.class)
				.addAnnotatedClass(Category.class).addAnnotatedClass(UserTyppe.class).addAnnotatedClass(User.class)
				.addAnnotatedClass(OrderDetail.class).addAnnotatedClass(Address.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}
}
