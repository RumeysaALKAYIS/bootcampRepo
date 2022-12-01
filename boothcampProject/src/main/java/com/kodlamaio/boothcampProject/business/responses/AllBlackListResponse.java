package com.kodlamaio.boothcampProject.business.responses;

import java.time.LocalDate;

import com.kodlamaio.boothcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllBlackListResponse {

	private int id;
	private Applicant applicant;
	private LocalDate date;
	private String reason;
}
