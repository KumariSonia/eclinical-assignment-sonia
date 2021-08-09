package com.ecw.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.apache.log4j.Logger;

import com.ecw.model.Category;
import com.ecw.model.Product;
import com.ecw.services.ProductService;
import com.ecw.util.Util;

public class ProductServiceImpl implements ProductService {

	static Session session;
	public final static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	public void createProduct(Product product) {
		// TODO Auto-generated method stub

		try {

			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();

			// Getting Transaction Object From Session Object
			session.beginTransaction();

			// Creating Transaction Entity
			session.save(product);

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

	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			Product product = getProductById(productId);
			session.delete(product);

			// Committing The Transactions To The Database
			session.getTransaction().commit();
			logger.info("\nProduct With Id?= " + productId + " Is Successfully Deleted From The Database!\n");
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
	public List<Product> getProductsDetail() {
		// TODO Auto-generated method stub
		List<Product> productsDetail = new ArrayList<Product>();
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			productsDetail = session.createQuery("FROM Product").list();
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
		return productsDetail;
	}

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			product = (Product) session.load(Product.class, productId);
			System.out.println(product);
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
		return product;
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			// Creating Transaction Entity
			session.update(product);

			// Committing The Transactions To The Database
			session.getTransaction().commit();
			logger.info("\nProduct Is Successfully Updated In The Database!\n");
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

	public void deleteAllRecords() {
		// TODO Auto-generated method stub
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			Query queryObj = session.createQuery("DELETE FROM Product");
			queryObj.executeUpdate();

			// Committing The Transactions To The Database
			session.getTransaction().commit();
			logger.info("\nSuccessfully Deleted All Records From The Database Table!\n");
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

}
