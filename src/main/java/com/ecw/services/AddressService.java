package com.ecw.services;

import java.util.List;

import com.ecw.model.Address;

public interface AddressService {

	public void createAddress(Address address);

	public void deleteAddress(int addressId);

	public List<Address> getAddressDetail();

	public Address getAddressById(int addressId);

	public void updateAddress(Address address);
}