package com.kodlamaio.boothcampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.boothcampProject.business.requets.CreatedApplicationRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdatedApplicationRequest;
import com.kodlamaio.boothcampProject.business.responses.CreatedApplicationResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllApplicationResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdatedApplicationResponse;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

@Service
public interface ApplicationServices {
	
	DataResult<List<GetAllApplicationResponse>>  getAll();
	DataResult<GetAllApplicationResponse> getByid(int id);
	DataResult<CreatedApplicationResponse>  add(CreatedApplicationRequest createdApplicationRequest);
	DataResult<UpdatedApplicationResponse>  update( UpdatedApplicationRequest updatedApplicationRequest);
	Result delete(int id);
	

	
}
