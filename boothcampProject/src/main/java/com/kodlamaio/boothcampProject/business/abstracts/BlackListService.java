package com.kodlamaio.boothcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.boothcampProject.business.requets.CreateBlackListRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateBlackListRequest;
import com.kodlamaio.boothcampProject.business.responses.AllBlackListResponse;
import com.kodlamaio.boothcampProject.business.responses.CreateBlackListResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateBlackListResponse;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;

public interface BlackListService  {
	DataResult<List<AllBlackListResponse>> getAll();
	DataResult<CreateBlackListResponse>  add(CreateBlackListRequest createBlackListRequest);
	DataResult<UpdateBlackListResponse>  update(UpdateBlackListRequest updateBlackListRequest);
	Result delete(int id);

}
