package com.ecw.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.ecw.model.Category;
import com.ecw.services.CategoryService;
import com.ecw.util.Util;

public class CategoryServiceImp implements CategoryService {

	static Session session;
	public final static Logger logger = Logger.getLogger(CategoryServiceImp.class);

	public void createCategory(Category catogory) {
		// TODO Auto-generated method stub
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			// Creating Transaction Entity
			session.save(catogory);

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

	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			Category category = getCategoryById(categoryId);
			session.delete(category);

			// Committing The Transactions To The Database
			session.getTransaction().commit();
			logger.info("\nCategory With Id?= " + categoryId + " Is Successfully Deleted From The Database!\n");
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
	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategoriesDetail() {
		// TODO Auto-generated method stub
		List<Category> categoriesDetail = new ArrayList<Category>();
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			categoriesDetail = session.createQuery("FROM Category").list();
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
		return categoriesDetail;
	}

	public Category getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		Category category = null;
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			category = (Category) session.load(Category.class, categoryId);
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
		return category;
	}

	public void updateCategory(Category catogory) {
		// TODO Auto-generated method stub
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			// Creating Transaction Entity
			session.update(catogory);

			// Committing The Transactions To The Database
			session.getTransaction().commit();
			logger.info("\nCategory Is Successfully Updated In The Database!\n");
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
}
