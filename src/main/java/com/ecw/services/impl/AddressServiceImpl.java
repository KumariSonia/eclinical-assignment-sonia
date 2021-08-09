package com.ecw.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.ecw.model.Address;
import com.ecw.services.AddressService;
import com.ecw.util.Util;

public class AddressServiceImpl implements AddressService {

	static Session session;
	public final static Logger logger = Logger.getLogger(AddressServiceImpl.class);

	public void createAddress(Address address) {
		// TODO Auto-generated method stub

		try {
			// Getting Session Object From SessionFactory
			session = Util.getSessionFactory().openSession();

			// Getting Transaction Object From Session Object
			session.beginTransaction();

			// Creating Transaction Entity
			session.save(address);

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

	public void deleteAddress(int addressId) {
		// TODO Auto-generated method stub

	}

	public List<Address> getAddressDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Address getAddressById(int addressId) {
		// TODO Auto-generated method stub

		Address address = null;
		// Getting Session Object From SessionFactory
		Session session = Util.getSessionFactory().openSession();
		try {

			// Getting Transaction Object From Session Object
			session.beginTransaction();

			address = (Address) session.load(Address.class, addressId);

		} catch (Exception sqlException) {
			if (session.getTransaction() != null) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return address;
	}

	public void updateAddress(Address address) {
		// TODO Auto-generated method stub

	}

}
