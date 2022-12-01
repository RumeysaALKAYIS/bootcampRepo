package com.kodlamaio.boothcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.boothcampProject.business.requets.CreatedBootCampRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateBootCampRequest;
import com.kodlamaio.boothcampProject.business.responses.CreatedBootCampResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllBootCampResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateBootCampResponses;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

public interface BootCampService {

	DataResult<List<GetAllBootCampResponse>> getAll();

	DataResult<CreatedBootCampResponse> add(CreatedBootCampRequest createdBootCampRequest);

	DataResult<UpdateBootCampResponses> update(UpdateBootCampRequest updateBootCampRequest);

	Result delete(int id);

}
