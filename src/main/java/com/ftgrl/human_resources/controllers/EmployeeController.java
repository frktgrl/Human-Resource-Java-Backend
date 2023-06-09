package com.ftgrl.human_resources.controllers;

import java.util.List;
import java.util.Optional;

import com.ftgrl.human_resources.models.Employee;
import com.ftgrl.human_resources.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees/")
@CrossOrigin
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<Employee>> getallEmployees(@RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		return new ResponseEntity<List<Employee>>(
				this.employeeService.getallEmployees(pageNo.orElse(1), pageSize.orElse(10)),
				HttpStatus.OK
			);
		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("getRestedUsers")
	public ResponseEntity<List<Employee>> getRestedUsers(@RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		return new ResponseEntity<List<Employee>>(
				this.employeeService.getRestedUsers(pageNo.orElse(1), pageSize.orElse(10)),
				HttpStatus.OK
			);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("getEmployeesByExperienceYear/{experienceYear}")
	public ResponseEntity<List<Employee>> getEmployeesByExperienceYear(@PathVariable int experienceYear, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		return new ResponseEntity<List<Employee>>(
				this.employeeService.getEmployeesByExperienceYear(experienceYear, pageNo.orElse(1), pageSize.orElse(10)),
				HttpStatus.OK
			);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("getEmployeeByMilitayCase/{experienceYear}")
	public ResponseEntity<List<Employee>> getEmployeeByMilitayCase(@PathVariable boolean isMilitayMissionDone, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		return new ResponseEntity<List<Employee>>(
				this.employeeService.getEmployeeByMilitayCase(isMilitayMissionDone, pageNo.orElse(1), pageSize.orElse(10)),
				HttpStatus.OK
			);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("getNotRestedUsers")
	public ResponseEntity<List<Employee>> getNotRestedUsers(@RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		return new ResponseEntity<List<Employee>>(
				this.employeeService.getNotRestedUsers(pageNo.orElse(1), pageSize.orElse(10)),
				HttpStatus.OK
			);
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
	@GetMapping("getById/{userId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int userId) {
		
		return new ResponseEntity<Employee>(
				this.employeeService.getEmployeeById(userId),
				HttpStatus.OK
			);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("delete/{userId}")
	public ResponseEntity<String> deleteById(@PathVariable int userId) {
		
		this.employeeService.delete(userId);
		
		return new ResponseEntity<String>(
				"Employee silindi...",
				HttpStatus.OK
			);
	}
}
