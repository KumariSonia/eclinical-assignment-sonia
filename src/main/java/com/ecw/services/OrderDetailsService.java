package com.ecw.services;

import java.util.List;

import com.ecw.model.OrderDetail;
import com.ecw.model.Product;

public interface OrderDetailsService {

	public void createOrderDetail(OrderDetail orderDetail);

	public List<OrderDetail> getOrderDetail();

	public OrderDetail getOrderDetailById(int orderDetailId);

	public int getAmmount(Product productById, int quantity);	
}
