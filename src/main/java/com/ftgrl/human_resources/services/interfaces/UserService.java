package com.ftgrl.human_resources.services.interfaces;

import java.util.List;

import com.ftgrl.human_resources.models.User;

public interface UserService {
	
	List<User> getallUsers(int pageNo, int pageSize);
	
	User getUserById(int userId);
	
	User getUserByEmail(String email);
	
	void add(User user);
	
	void delete(int userId);
	
	void update(User user);
}
