package com.kodlamaio.boothcampProject.business.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllBootCampResponse {
	private int id;
	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private int State;
}
