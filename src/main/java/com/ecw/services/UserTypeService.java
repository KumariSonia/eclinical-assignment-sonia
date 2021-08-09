package com.ecw.services;

import java.util.List;

import com.ecw.model.UserTyppe;

public interface UserTypeService {

	public void createUserType(UserTyppe userType);

	public void deleteUserType(int userTypeId);

	public List<UserTyppe> getUsersTypeDetail();

	public UserTyppe getUserTypeById(int userTypeId);

	public void updateUserType(UserTyppe userType);
	
}
