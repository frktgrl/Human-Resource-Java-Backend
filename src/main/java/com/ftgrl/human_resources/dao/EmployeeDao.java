package com.ftgrl.human_resources.dao;

import java.util.List;

import com.ftgrl.human_resources.models.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	
	@Query("From Employee e where e.isRest = :true")
	List<Employee> getRestedUsers(Pageable pageable);

	@Query("From Employee e where e.isRest = :false")
	List<Employee> getNotRestedUsers(Pageable pageable);
	
	@Query("From Employee e where e.experienceYear = :experienceYear")
	List<Employee> getEmployeesByExperienceYear(int experienceYear, Pageable pageable);
	
	@Query("From Employee e where e.isMilitayMissionDone = :isMilitayMissionDone")
	List<Employee> getEmployeeByMilitayCase(boolean isMilitayMissionDone, Pageable pageable);
}
