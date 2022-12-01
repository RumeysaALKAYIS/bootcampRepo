package com.kodlamaio.boothcampProject.entities.blackList;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kodlamaio.boothcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "blacklist")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlackList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "applicantid")
	private Applicant applicant;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "reason")
	private String reason;
}
