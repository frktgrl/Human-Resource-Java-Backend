package com.ftgrl.human_resources.services.interfaces;

import com.ftgrl.human_resources.models.Employee;
import com.ftgrl.human_resources.models.HumanResourceUser;

public interface AuthService {

	void register(HumanResourceUser humanResourceUser);
	
	void register(Employee employee);
}
