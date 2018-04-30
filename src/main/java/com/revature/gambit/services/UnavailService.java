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

	public List<Unavailabilities> findAllUnavailabilities() {
		return unavailRepo.findAll();
	}

	public Unavailabilities createUnavailabilities(Unavailabilities unavailabilities) {
		return unavailRepo.saveAndFlush(unavailabilities);
	}
	
}
