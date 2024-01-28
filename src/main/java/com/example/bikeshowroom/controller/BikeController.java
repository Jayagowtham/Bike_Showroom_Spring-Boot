package com.example.bikeshowroom.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bikeshowroom.model.Bike;
import com.example.bikeshowroom.service.BikeService;

@Controller
public class BikeController {
	
@Autowired
private BikeService bikeService;

@GetMapping("/")
public String homepage() 
{
    return "index";	
}

@GetMapping("/BikePage/view")                                                // this name says for the URL name ( this name should be same in index URl name too line 18)
public String bikeViewPage(Model model)
{
	model.addAttribute("allBikes",bikeService.showAllBikes());                // you call the service from controller and service will call the repositary 
	return("bike/view");                                                       // this naming is for mapping as the view page is inside the folder for separation
}	

@GetMapping("/BikePage/add")
public String addPage(Model model)
{
	model.addAttribute("obj", new Bike());
	return "bike/add";
}

@PostMapping("/BikePage/add")                                              // what you wrote in action in add.html because the the data needs to be cared to website sooo
public String addBike(@ModelAttribute("obj")Bike bike)                     //this Bike is from repostitary , bike is like local obj to use it     
{
	Optional<Bike> opt=bikeService.searchBike(bike.getModel());
	if(opt.isEmpty())
	{
		bikeService.addNewBike(bike);
		return "redirect:/BikePage/view";
	}
	else
	{
		return "redirect:/BikePage/add?failed";
	}
	
}
@GetMapping("/BikePage/edit/{id}")                            // this name should be same with edit.html line 19 and line 39 as like to address
public String editPage(@PathVariable("id")String mod, Model model)
{
	model.addAttribute("obj", bikeService.searchBike(mod));
	return "/bike/edit";                                 // this name should be same with path folder name , only when you redirect it to another page go with url name

}
@PostMapping("BikePage/edit")
public String editBike(@ModelAttribute("obj") Bike bike)           // the Bike bike is converting the variable into local once
{
	bikeService.addNewBike(bike);
	return "redirect:/BikePage/view";                       // this statement will be same as in controller line 49 becoz only edit is going so new methods
}

@GetMapping("/Bikepage/delete/{id}")                         // this name should be same with edit.html line 19 and line 39 as like to address and this line is simialr to getmapping edit line /
public String deleteBike(@PathVariable("id") String model)
{
	bikeService.deleteBike(model);
	return "redirect:/BikePage/view";
}

@GetMapping("/search/brand")
public String showBikes(@RequestParam("key") String brand, Model model)          // the requestparam is for getting info from view html page 
{
	model.addAttribute("allBikes", bikeService.showBikesBrandWise(brand));         //allbikes should be same name from viewpage line 33 and bikeservice is from new method add for is in bike service
	return "/bike/view";
}

@GetMapping("/search/priceandmileage")
public String showBikePriceAndMileage(@RequestParam("PAM") int price, Model model)
{
	model.addAttribute("allBikes", bikeService.showBikes(price));
	return "/bike/view";
}

}
























