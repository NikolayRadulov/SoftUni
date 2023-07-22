package com.example.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.football.models.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
	Team getByName(String name);
}
