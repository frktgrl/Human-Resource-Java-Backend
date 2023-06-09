package com.ftgrl.human_resources.services.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftgrl.human_resources.dao.EmployeeDao;
import com.ftgrl.human_resources.models.Employee;
import com.ftgrl.human_resources.models.OperationClaim;
import com.ftgrl.human_resources.models.User;
import com.ftgrl.human_resources.services.interfaces.EmployeeService;
import com.ftgrl.human_resources.services.interfaces.OperationClaimService;
import com.ftgrl.human_resources.services.interfaces.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	private UserService userService;
	private OperationClaimService operationClaimService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, UserService userService, 
			OperationClaimService operationClaimService, PasswordEncoder passwordEncoder) {
		super();
		this.employeeDao = employeeDao;
		this.userService = userService;
		this.operationClaimService = operationClaimService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<Employee> getallEmployees(int pageNo, int pageSize) {
		log.info("Bütün çalışanlar listelendi");
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return this.employeeDao.findAll(pageable).getContent();
	}

	@Override
	public List<Employee> getRestedUsers(int pageNo, int pageSize) {
		
		log.info("İzinli olan çalışanlar listelendi...");
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return this.employeeDao.getRestedUsers(pageable);
	}

	@Override
	public List<Employee> getNotRestedUsers(int pageNo, int pageSize) {
		
		log.info("İzinli olmayan çalışanlar listelendi...");
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return this.employeeDao.getNotRestedUsers(pageable);
	}

	@Override
	public Employee getEmployeeById(int userId) {

		log.info("Çalışan id si ile getirildi");
		
		return this.employeeDao.getById(userId);
	}

	@Override
	public void add(Employee employee) {
		
		User user = this.userService.getUserByEmail(employee.getEmail());
		
		if (user != null) {
			log.info("Email ile kayıtlı kullanıcı var!");
			return;
		}
		
		OperationClaim claim = this.operationClaimService.getClaimByClaimName("EMPLOYEE");
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		employee.setOperationClaim(claim);
		
		this.employeeDao.save(employee);
	}

	@Override
	public void delete(int userId) {
		
		this.employeeDao.deleteById(userId);
		
	}

	@Override
	public void update(Employee employee) {
		
		// Dto ile maplemek ???
		
	}

	@Override
	public List<Employee> getEmployeesByExperienceYear(int expreinceYear, int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return this.employeeDao.getEmployeesByExperienceYear(expreinceYear, pageable);
	}

	@Override
	public List<Employee> getEmployeeByMilitayCase(boolean isMilitayMissionDone, int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return this.employeeDao.getEmployeeByMilitayCase(isMilitayMissionDone, pageable);
	}


}
