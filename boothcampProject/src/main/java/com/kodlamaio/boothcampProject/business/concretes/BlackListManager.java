package com.kodlamaio.boothcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.kodlamaio.boothcampProject.business.abstracts.BlackListService;
import com.kodlamaio.boothcampProject.business.requets.CreateBlackListRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateBlackListRequest;
import com.kodlamaio.boothcampProject.business.responses.AllBlackListResponse;
import com.kodlamaio.boothcampProject.business.responses.CreateBlackListResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateBlackListResponse;
import com.kodlamaio.boothcampProject.core.utilities.exeptions.BusinessExeption;
import com.kodlamaio.boothcampProject.core.utilities.mapping.ModelService;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.boothcampProject.dataAccess.abstracts.BlackListRepository;
import com.kodlamaio.boothcampProject.entities.blackList.BlackList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BlackListManager implements BlackListService {

	private BlackListRepository blackListRepository;
	private ModelService modelService;

	@Override
	public DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest) {
		BlackList blackList=this.modelService.forRequest().map(createBlackListRequest, BlackList.class);
		this.blackListRepository.save(blackList);
		CreateBlackListResponse blackListResponse=this.modelService.forResponse().map(blackList, CreateBlackListResponse.class);
		return new SuccessDataResult<>(blackListResponse);
	}

	@Override
	public DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest) {
		
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<AllBlackListResponse>> getAll() {
		List<AllBlackListResponse> allBlackListResponses = this.blackListRepository.findAll().stream()
				.map(b -> this.modelService.forResponse().map(b, AllBlackListResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<AllBlackListResponse>>(allBlackListResponses);
	}
	
	private void checkIfExistingById(int id) {
		if (!this.blackListRepository.existsById(id)) {
			throw new BusinessExeption("Error");

		}

	}


}
