package com.kodlamaio.boothcampProject.entities.bootcamps;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.boothcampProject.entities.applications.Application;
import com.kodlamaio.boothcampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="boothcamps")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Boothcamp {
	
	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name= "name")
	private String name;
	@Column (name="datestart")
	private LocalDate dateStart; 
	@Column (name="dateend")
	private LocalDate dateEnd;
	@Column(name="state")
	private int State;
	
	@ManyToOne
	@JoinColumn(name="instructorid")
	private Instructor instructor;
	
	@OneToMany(mappedBy = "boothcamp")
	private List< Application> application;
	

}
