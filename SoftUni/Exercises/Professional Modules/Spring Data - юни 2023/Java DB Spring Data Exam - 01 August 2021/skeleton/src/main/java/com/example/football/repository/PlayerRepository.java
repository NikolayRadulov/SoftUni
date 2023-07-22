package com.example.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.football.models.entity.Player;

import java.util.List;

@Repository
public interface PlayerRepository  extends JpaRepository<Player, Long>{

	Player getByEmail(String email);
	
	@Query("SELECT p from Player as p JOIN p.stat as s ORDER BY s.shooting DESC, s.passing DESC, s.endurance DESC, p.lastName")
	List<Player> findOrderedPlayers();
}
