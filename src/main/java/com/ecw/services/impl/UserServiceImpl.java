package com.ecw.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ecw.model.Product;
import com.ecw.model.User;
import com.ecw.model.UserTyppe;
import com.ecw.services.UserService;
import com.ecw.services.UserTypeService;
import com.ecw.util.Util;

public class UserServiceImpl implements UserService {

	static Session session;
	public final static Logger logger = Logger.getLogger(UserServiceImpl.class);

	public void createUser(User user) {
		// TODO Auto-generated method stub

		try {

			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();

			// Getting Transaction Object From Session Object
			session.beginTransaction();

			// Creating Transaction Entity
			session.save(user);

			// Committing The Transactions To The Database
			session.getTransaction().commit();
			logger.info("\nSuccessfully Created Record In The Database!\n");
		} catch (Exception exception) {
			if (null != session.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			exception.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

	public List<User> getUsersDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			user = (User) session.load(User.class, userId);
//			session.close();
		} catch (Exception sqlException) {
			if (null != session.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	public void getUserByEmailAndPassword(String email, String password) {
		User user = null;

		try {

			String query = "from User where userEmail =: e and userPassword=: p";
			session = Util.getSessionFactory().openSession();
			Query q = session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			user = (User) q.uniqueResult();
			session.close();
			if (user != null) {
				System.out.println("Welcome  ..." + user.getUserType().getUserType());
			} else {
				System.out.println("invalid details");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
