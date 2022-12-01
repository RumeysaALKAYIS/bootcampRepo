package com.kodlamaio.boothcampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.boothcampProject.entities.bootcamps.Boothcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructors")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Instructor extends User {

	@Column(name = "companyName")
	private String companyName;
	
	@OneToMany(mappedBy = "instructor")
	private List<Boothcamp> boothcamps;

}
