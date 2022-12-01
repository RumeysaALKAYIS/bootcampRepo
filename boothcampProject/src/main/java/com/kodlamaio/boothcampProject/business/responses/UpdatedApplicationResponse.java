package com.kodlamaio.boothcampProject.business.responses;

import org.hibernate.internal.build.AllowSysOut;

import com.kodlamaio.boothcampProject.entities.bootcamps.Boothcamp;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllowSysOut
public class UpdatedApplicationResponse {
	private int id;
	private String name;
	private int applicantId;
	private int boothcampId;

}
