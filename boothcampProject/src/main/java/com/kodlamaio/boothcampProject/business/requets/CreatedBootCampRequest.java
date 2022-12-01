package com.kodlamaio.boothcampProject.business.requets;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreatedBootCampRequest {

	@NotBlank(message = "Cannot be blank")
	@Size(min = 3, max = 255, message = "Must be at least 3 characters and at most 255 characters .")
	private String name;
		
	private String dateStart;
	private String dateEnd;
	@NotNull(message =  "Please select an instructor")
	private int instructorId;
	private int State;
}
