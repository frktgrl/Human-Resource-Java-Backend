package com.ftgrl.human_resources.services.interfaces;

import java.util.List;

import com.ftgrl.human_resources.models.Employee;

public interface EmployeeService {
	
	List<Employee> getallEmployees(int pageNo, int pageSize);
	
	List<Employee> getRestedUsers(int pageNo, int pageSize);
	
	List<Employee> getNotRestedUsers(int pageNo, int pageSize);
	
	List<Employee> getEmployeesByExperienceYear(int expreinceYear, int pageNo, int pageSize);
	
	List<Employee> getEmployeeByMilitayCase(boolean isMilitayMissionDone, int pageNo, int pageSize);
	
	Employee getEmployeeById(int userId);
	
	void add(Employee employee);
	
	void delete(int userId);
	
	void update(Employee employee);
}
