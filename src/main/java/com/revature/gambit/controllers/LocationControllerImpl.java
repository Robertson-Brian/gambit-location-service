//package com.revature.gambit.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.gambit.entities.Location;
//import com.revature.gambit.services.LocationService;
//
//
//@RestController
//@RequestMapping("location")
//public class LocationControllerImpl {
//
//	LocationService locationService;
//
//	@Autowired
//	public LocationControllerImpl(LocationService locationService) {
//		this.locationService = locationService;
//	}
//
//	@GetMapping("/")
//	public List<Location> getAllLocations() {
//		return locationService.findAllLocation();
//	}
//
//	@GetMapping("/{id}")
//	public Location getLocationByID(Integer id) {
//		return locationService.findLocationByID(id);
//	}
//
//	@PostMapping("/")
//	public Location createLocation(Location location) {
//		return locationService.saveLocation(location);
//	}
//
//	@PutMapping("/{id}")
//	public Location updateLocation(Integer id, Location location) {
//		return locationService.saveLocation(location);
//	}
//
//	@DeleteMapping("/{id}")
//	public Location deleteLocationByID(Integer id) {
//		return locationService.deactivateLocation(id);
//	}
//
//}
