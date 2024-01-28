package com.example.bikeshowroom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;                         // check the imports are there with previous projects reference
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bikeshowroom.model.Bike;
import com.example.bikeshowroom.service.BikeService;

@RestController
public class HomeRestController {
	
	@Autowired
	private BikeService bikeservice;
	                                             // the getmapping "api/bikes should be crystal clear like singular ,pural,what needed and no return type as its not returning html page so go for list and no parametre model direct call service and inject it 
@GetMapping("/api/bikes")                              
public List<Bike> getAllBikes()
{
	return bikeservice.showAllBikes();
}

@GetMapping("/api/bike/{id}")
public Optional<Bike> getBike(@PathVariable("id") String model)                  
{
	return bikeservice.searchBike(model);                                            
}

//@GetMapping("/api/bike/{id}")
//public List<Bike> showBikesBrandWise(@PathVariable("id")String brand)                  // i craeted a or replaced a impl from bikeserimpl//public Optional<Bike> getBike(@PathVariable("id") String model)
//{
//	return bikeservice.findByBrand(brand);                                            //bikeservice.searchBike(model)
//}


}
