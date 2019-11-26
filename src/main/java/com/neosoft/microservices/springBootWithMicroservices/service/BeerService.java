package com.neosoft.microservices.springBootWithMicroservices.service;

import java.util.UUID;

import com.neosoft.microservices.springBootWithMicroservices.model.BeerDto;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
    BeerDto saveNewBeer(BeerDto beerDto);
    void updateBeer(UUID beerID,  BeerDto beerDto);
    void deleteById(UUID beerID);
}
