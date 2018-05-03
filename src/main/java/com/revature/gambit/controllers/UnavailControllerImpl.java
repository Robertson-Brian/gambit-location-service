package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.entities.Unavailabilities;
import com.revature.gambit.services.UnavailService;

@CrossOrigin
@RestController
@RequestMapping("unavailabilities")
public class UnavailControllerImpl implements UnavailController {

	private UnavailService unavailService;

	@Autowired
	public UnavailControllerImpl(UnavailService unavailService) {
		this.unavailService = unavailService;
	}

	/**
	 * HTTP GET getAllUnavailabilites - Handles request to Location Service API to
	 * get all unavailabilites
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * 
	 * @return On success a list of buildings
	 */
	@Override
	@GetMapping("/")
	public List<Unavailabilities> getAllUnavailabilities() {
		return unavailService.findAllUnavailabilities();
	}

	/**
	 * HTTP POST createUnavailabilities - Handles requests to Location Service API
	 * to create a new unavailabilities
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @author Jake Trump | 1803-USF-MAR05
	 * @param location
	 *            from the request body
	 * @return On success the method returns the created location. On failure
	 *         returns a null.
	 */
	@Override
	@PostMapping("/")
	public Unavailabilities createUnavailabilities(@RequestBody Unavailabilities unavailabilities) {
		return unavailService.createUnavailabilities(unavailabilities);
	}

	// @Override
	// public Unavailabilities updateUnavailabilities(Long id, Unavailabilities
	// unavailabilities) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public Unavailabilities deleteUnavailabilities(Long id) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
