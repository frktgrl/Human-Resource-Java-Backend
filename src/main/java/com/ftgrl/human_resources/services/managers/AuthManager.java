package com.ftgrl.human_resources.services.managers;

import com.ftgrl.human_resources.services.interfaces.AuthService;
import com.ftgrl.human_resources.services.interfaces.EmployeeService;
import com.ftgrl.human_resources.services.interfaces.HumanResourceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftgrl.human_resources.models.Employee;
import com.ftgrl.human_resources.models.HumanResourceUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthManager implements AuthService {

	private EmployeeService employeeService;
	private HumanResourceUserService humanResourceUserService;
	
	@Autowired
	public AuthManager(EmployeeService employeeService, HumanResourceUserService humanResourceUserService) {
		super();
		this.employeeService = employeeService;
		this.humanResourceUserService = humanResourceUserService;
	}

	@Override
	public void register(HumanResourceUser humanResourceUser) {
		log.info("İnsan kaynakları yöneticisi kaydedildi....");
		this.humanResourceUserService.add(humanResourceUser);
		
	}

	@Override
	public void register(Employee employee) {
		
		log.info("Çalışan kaydedildi....");
		
		this.employeeService.add(employee);
		
	}

}
