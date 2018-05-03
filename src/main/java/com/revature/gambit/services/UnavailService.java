package com.revature.gambit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gambit.entities.Unavailabilities;
import com.revature.gambit.repository.UnavailRepo;

@Service
public class UnavailService {
	
	private UnavailRepo unavailRepo;
	
	@Autowired
	public UnavailService(UnavailRepo unavailRepo) {
		this.unavailRepo = unavailRepo;
	}
	public UnavailService() { }

	/**
	 * This method utilizes Spring's JPA repository interface to query the database
	 * for all known Unavailabilities.
	 * 
	 * @author Stephen Lovick | 1803-USF-MAR05
	 * @return Returns a list of ALL rooms in the Database
	 */
	public List<Unavailabilities> findAllUnavailabilities() {
		return unavailRepo.findAll();
	}

	public Unavailabilities createUnavailabilities(Unavailabilities unavailabilities) {
		return unavailRepo.saveAndFlush(unavailabilities);
	}
	
}
