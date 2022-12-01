package com.kodlamaio.boothcampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.boothcampProject.entities.applications.Application;
import com.kodlamaio.boothcampProject.entities.blackList.BlackList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applicants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends User {

	@Column(name = "about")
	private String about;

	@OneToMany(mappedBy = "applicant")
	private List<Application> applications;

	@OneToMany(mappedBy = "applicant")
	private List<BlackList> blackList;

}
