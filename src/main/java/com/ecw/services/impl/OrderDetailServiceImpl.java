package com.ecw.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.ecw.model.OrderDetail;
import com.ecw.model.Product;
import com.ecw.services.OrderDetailsService;
import com.ecw.services.ProductService;
import com.ecw.util.Util;

public class OrderDetailServiceImpl implements OrderDetailsService {

	static Session session;
	public final static Logger logger = Logger.getLogger(OrderDetailServiceImpl.class);

	public void createOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		try {

			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();

			// Getting Transaction Object From Session Object
			session.beginTransaction();

			// Creating Transaction Entity
			session.save(orderDetail);

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

	@SuppressWarnings("unchecked")
	public List<OrderDetail> getOrderDetail() {
		// TODO Auto-generated method stub
		List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();

			orderDetail = session.createQuery("FROM OrderDetail").list();
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
		return orderDetail;

	}

	public OrderDetail getOrderDetailById(int orderDetailId) {
		// TODO Auto-generated method stub
		OrderDetail orderDetail = null;
		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			session.beginTransaction();
			orderDetail = (OrderDetail) session.load(OrderDetail.class, orderDetailId);
			System.out.println(orderDetail);
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
		return orderDetail;
	}

	// Calculating amount in order and decreasing the quantity from product

	public int getAmmount(Product product, int quantity) {
		int updatedQuantity = product.getQuantity() - quantity;
		product.setQuantity(updatedQuantity);

//		System.out.println("updatedQuantity..." + updatedQuantity);

		ProductService productservice = new ProductServiceImpl();
		productservice.updateProduct(product);

		int amount = product.getPrice() * quantity;

		return amount;

	}

}
