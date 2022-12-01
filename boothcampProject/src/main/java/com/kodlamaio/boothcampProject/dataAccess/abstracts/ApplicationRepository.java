package com.kodlamaio.boothcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.boothcampProject.entities.applications.Application;

public interface ApplicationRepository  extends JpaRepository<Application, Integer>{

	boolean existsByApplicant(int applicant);
}
