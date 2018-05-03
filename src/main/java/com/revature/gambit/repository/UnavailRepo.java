package com.revature.gambit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.Unavailabilities;

@Repository
public interface UnavailRepo extends JpaRepository<Unavailabilities, Integer>{

}
