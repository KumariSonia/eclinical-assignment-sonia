package com.ecw.services;

import java.util.List;

import com.ecw.model.User;

public interface UserService {

	public void createUser(User user);

	public void deleteUser(int userId);

	public List<User> getUsersDetail();

	public User getUserById(int userId);

	public void updateUser(User user);

	public void getUserByEmailAndPassword(String email, String password);

}
