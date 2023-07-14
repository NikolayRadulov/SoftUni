package com.gameshop.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gameshop.app.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	Game findByTitle(String title);
}
