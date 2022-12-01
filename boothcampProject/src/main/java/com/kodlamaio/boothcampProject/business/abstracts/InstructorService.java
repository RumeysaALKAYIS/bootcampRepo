package com.kodlamaio.boothcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.boothcampProject.business.requets.CreateInstructorRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateInstructorRequest;
import com.kodlamaio.boothcampProject.business.responses.CreateInstructorResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllInstructorResponse;
import com.kodlamaio.boothcampProject.business.responses.GetInstructorResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateInstructorResponse;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

public interface InstructorService {
	
	 Result delete(int id);
	 DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);
	 DataResult<List<GetAllInstructorResponse>> getAll();
	 DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);
	 DataResult<GetInstructorResponse> getById(int id);
}
