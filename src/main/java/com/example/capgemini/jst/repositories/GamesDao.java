package com.example.capgemini.jst.repositories;


import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.capgemini.jst.data.GamesEntity;

@Repository
public class GamesDao {
	Set<GamesEntity> setOfGames;
	
	private GamesDao(){
		this.setOfGames = new HashSet<>();
	}
	
}
