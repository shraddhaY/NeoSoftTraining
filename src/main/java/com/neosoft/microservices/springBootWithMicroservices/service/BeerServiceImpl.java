package com.neosoft.microservices.springBootWithMicroservices.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.neosoft.microservices.springBootWithMicroservices.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Gallaxy Cat")
				.beerStyle("pale Ale")
				.build();

	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(UUID beerID, BeerDto beerDto) {
			log.debug("updating beer");
	}

	@Override
	public void deleteById(UUID beerID) {
       log.debug("Deleting a beer");		
	}
	
	

}
