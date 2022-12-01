package com.kodlamaio.boothcampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.boothcampProject.business.requets.CreateApplicantRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateApplicantRequest;
import com.kodlamaio.boothcampProject.business.responses.CreateApplicantResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllApplicantResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateApplicantResponse;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

@Service
public interface ApplicantService {

	public DataResult<List<GetAllApplicantResponse>> getAll();

	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);

	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest createApplicantRequest);

	public Result delete(int id);

	public DataResult<GetAllApplicantResponse> getById(int id);

}
