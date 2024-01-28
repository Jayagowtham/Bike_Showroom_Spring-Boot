package com.example.bikeshowroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bikeshowroom.model.Bike;
import com.example.bikeshowroom.repository.BikeRepository;

@Service
public class BikeServiceImpl implements BikeService {
	@Autowired
	private BikeRepository bikeRepo;

	@Override
	public List<Bike> showAllBikes() {
		
		return bikeRepo.findAll();
	}

	@Override
	public Optional<Bike> searchBike(String model) {
		
		return bikeRepo.findById(model);
	}

	@Override
	public Bike addNewBike(Bike bike) {
	
		return bikeRepo.save(bike);
	}

	@Override
	public void deleteBike(String model) {
		bikeRepo.deleteById(model);
		
	}

	@Override
	public List<Bike> showBikesBrandWise(String brand) {
		
		return bikeRepo.findByBrand(brand);
	}

	@Override
	public List<Bike> showBikes(int price) {             // two parameter where passed but i removed one to check mileage  // this is used for SQL query find method
		
		return bikeRepo.findBikes(price);
	}
// this is created for rest controller
//	@Override
//	public List<Bike> findByBrand(String brand) {
//		return bikeRepo.findByBrand(brand);
		
//	}
	

}
