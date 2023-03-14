package com.ftgrl.human_resources.services.interfaces;

import com.ftgrl.human_resources.models.HumanResourceUser;

public interface HumanResourceUserService {
	
	void add(HumanResourceUser user);
	
	void delete(int userId);

}
