package com.kodlamaio.boothcampProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.boothcampProject.business.abstracts.BootCampService;
import com.kodlamaio.boothcampProject.business.constants.Messages;
import com.kodlamaio.boothcampProject.business.requets.CreatedBootCampRequest;
import com.kodlamaio.boothcampProject.business.requets.UpdateBootCampRequest;
import com.kodlamaio.boothcampProject.business.responses.CreatedBootCampResponse;
import com.kodlamaio.boothcampProject.business.responses.GetAllBootCampResponse;
import com.kodlamaio.boothcampProject.business.responses.UpdateBootCampResponses;
import com.kodlamaio.boothcampProject.core.utilities.mapping.ModelService;
import com.kodlamaio.boothcampProject.core.utilities.results.DataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.Result;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.boothcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.boothcampProject.dataAccess.abstracts.BootCampRepository;
import com.kodlamaio.boothcampProject.entities.bootcamps.Boothcamp;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BootCampManager implements BootCampService {

	private BootCampRepository bootCampRepository;
	private ModelService modelService;

	@Override
	public DataResult<List<GetAllBootCampResponse>> getAll() {

		List<GetAllBootCampResponse> allBootCampResponses = bootCampRepository.findAll().stream()
				.map(b -> modelService.forResponse().map(b, GetAllBootCampResponse.class)).collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllBootCampResponse>>(allBootCampResponses);
	}

	@Override
	public DataResult<CreatedBootCampResponse> add(CreatedBootCampRequest createdBootCampRequest) {
		Boothcamp boothcamp = this.modelService.forRequest().map(createdBootCampRequest, Boothcamp.class);
		boothcamp.setDateStart(stringToLocalDate(createdBootCampRequest.getDateStart()));
		boothcamp.setDateEnd(stringToLocalDate(createdBootCampRequest.getDateEnd()));

		this.bootCampRepository.save(boothcamp);

		CreatedBootCampResponse campResponse = this.modelService.forResponse().map(boothcamp,
				CreatedBootCampResponse.class);
		return new SuccessDataResult<CreatedBootCampResponse>(campResponse, Messages.BootcampCreated);
	}

	@Override
	public DataResult<UpdateBootCampResponses> update(UpdateBootCampRequest updateBootCampRequest) {
	 LocalDate dateStart =	stringToLocalDate(updateBootCampRequest.getDateStart());
	 LocalDate dateEnd =	stringToLocalDate(updateBootCampRequest.getDateEnd());
		 
		Boothcamp boothcamp = this.modelService.forRequest().map(updateBootCampRequest, Boothcamp.class);
		boothcamp.setDateStart(dateStart);
		boothcamp.setDateEnd(dateEnd);
		this.bootCampRepository.save(boothcamp);
		UpdateBootCampResponses updateBootCampResponses = this.modelService.forResponse().map(boothcamp,
				UpdateBootCampResponses.class);
		return new SuccessDataResult<>(updateBootCampResponses);
	}

	@Override
	public Result delete(int id) {
		this.bootCampRepository.deleteById(id);
		return new SuccessResult();
	}

	private LocalDate stringToLocalDate(String change) {
		return LocalDate.parse(change);

	}

}
