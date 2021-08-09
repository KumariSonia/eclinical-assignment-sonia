package com.ecw.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.ecw.model.Product;
import com.ecw.model.UserTyppe;
import com.ecw.services.UserTypeService;
import com.ecw.util.Util;

public class UserTypeServiceImpl implements UserTypeService {

	static Session session;
	public final static Logger logger = Logger.getLogger(UserTypeServiceImpl.class);

	public void createUserType(UserTyppe userType) {
		// TODO Auto-generated method stub

		try {

			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();

			// Getting Transaction Object From Session Object
			session.beginTransaction();

			// Creating Transaction Entity
			session.save(userType);

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

	public void deleteUserType(int userTypeId) {
		// TODO Auto-generated method stub

	}

	public List<UserTyppe> getUsersTypeDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserTyppe getUserTypeById(int userTypeId) {
		// TODO Auto-generated method stub
		UserTyppe userType = null;
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			userType = (UserTyppe) session.load(UserTyppe.class, userTypeId);
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

		return userType;
	}

	public void updateUserType(UserTyppe userType) {
		// TODO Auto-generated method stub

	}

}
