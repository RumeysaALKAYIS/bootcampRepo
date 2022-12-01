package com.kodlamaio.boothcampProject.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelService {

	 ModelMapper forResponse();
	 ModelMapper forRequest();
}
