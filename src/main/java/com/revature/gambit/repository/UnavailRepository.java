package com.revature.gambit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gambit.entities.Unavailabilities;

public interface UnavailRepository extends JpaRepository<Unavailabilities, Long>{

}
