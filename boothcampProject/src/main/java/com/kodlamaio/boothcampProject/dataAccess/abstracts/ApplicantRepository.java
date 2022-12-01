package com.kodlamaio.boothcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.boothcampProject.entities.users.Applicant;

public interface ApplicantRepository  extends JpaRepository<Applicant, Integer>{

	// boolean existsByNatinalIdenty(String natinalidenty);
}
