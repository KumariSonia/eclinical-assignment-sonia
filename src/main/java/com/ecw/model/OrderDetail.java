package com.ecw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@OneToOne
	private Address adress;

	@OneToOne
	private Product product;

	private int quantity;

	@OneToOne
	private User user;

	private int amount;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", adress=" + adress + ", quantity=" + quantity + ", user=" + user
				+ ", amount=" + amount + "]";
	}
}