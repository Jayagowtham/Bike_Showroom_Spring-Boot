package com.example.bikeshowroom.service;

import java.util.List;
import java.util.Optional;

import com.example.bikeshowroom.model.Bike;

public interface BikeService {
	
	List<Bike> showAllBikes(); // any name can be used instant of showAllBike like DetailsBike
	
	Optional<Bike> searchBike(String model); // any name can be used instant of searchBike like search
	
	Bike addNewBike(Bike bike);
	
	void deleteBike(String model);
	
	List<Bike> showBikesBrandWise(String brand);                 //method name should be detailed to help for the company   and List<Bike> shold be same with reposi 
	
	//then go to serviceimpl and write class and return repo.findbybrand
     List<Bike> showBikes(int price);             // two parameter where passed but i removed one to check mileage

//	List<Bike> findByBrand(String brand);
}
