package com.kodlamaio.boothcampProject.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.boothcampProject.entities.users.Employee;

public interface EmployoeeRepository  extends JpaRepository<Employee, Integer>{

	boolean existsByNatinalIdenty (String natinalIdenty);
	Employee findByNatinalIdenty (String natinalIdenty);
}
