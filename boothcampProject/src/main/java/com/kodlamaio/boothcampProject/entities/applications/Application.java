package com.kodlamaio.boothcampProject.entities.applications;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kodlamaio.boothcampProject.entities.blackList.BlackList;
import com.kodlamaio.boothcampProject.entities.bootcamps.Boothcamp;
import com.kodlamaio.boothcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="applicantid")
	private Applicant  applicant;
	
	@ManyToOne
	@JoinColumn(name="boothcampid")
	private Boothcamp boothcamp;
	
	

}
