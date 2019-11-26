package com.neosoft.microservices.springBootWithMicroservices.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.microservices.springBootWithMicroservices.model.BeerDto;
import com.neosoft.microservices.springBootWithMicroservices.service.BeerService;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {

	@Autowired
	BeerService beerservice;
	
	public BeerController(BeerService beerservice){
		this.beerservice=beerservice;
	}
	
	
	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
		System.out.println(beerId);
		return new ResponseEntity<>(beerservice.getBeerById(beerId),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(@RequestBody BeerDto beerdto){
		BeerDto savedDto =beerservice.saveNewBeer(beerdto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Location", "api/v1/beer"+savedDto.getId().toString());
		return new ResponseEntity(headers,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerdto){
		beerservice.updateBeer(beerId, beerdto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity handleDelete(@PathVariable("beerId") UUID beerId){
		return null;
		
	}
	
	
}
