package com.revature.gambit.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.revature.gambit.entities.Unavailabilities;

public interface UnavailController {
	
	List<Unavailabilities>getAllUnavailabilities();
	Unavailabilities createUnavailabilities(@RequestBody Unavailabilities unavailabilities);
	//Unavailabilities updateUnavailabilities(@PathVariable(name = "id") Long id, @RequestBody Unavailabilities unavailabilities);
	//Unavailabilities deleteUnavailabilities(@PathVariable(name = "id") Long id);

}
