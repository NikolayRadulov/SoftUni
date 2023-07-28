package com.example.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.football.models.entity.Stat;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long>{
	
	Stat getByShootingAndPassingAndEndurance(float shooting, float passing, float indurance);
}
