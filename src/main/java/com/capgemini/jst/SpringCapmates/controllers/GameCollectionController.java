package com.capgemini.jst.SpringCapmates.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.exceptions.NoSuchElementInDatabaseException;
import com.capgemini.jst.SpringCapmates.services.UserGameCollectionService;
import com.capgemini.jst.SpringCapmates.transferObjects.FindGameByParamsRequestDto;
import com.capgemini.jst.SpringCapmates.transferObjects.GameDto;
import com.capgemini.jst.SpringCapmates.transferObjects.UserGameCollectionDto;

@Controller
@RequestMapping("/user/game-collection") // czy ten request mapping jest dobry,
											// czy raczej sam game collection i
// co jesli chcialbym zeby id w metodach było pomiędzy user a game collection,
// da sie?
@ResponseBody
public class GameCollectionController {

	private final UserGameCollectionService userGameCollectionService;

	@Autowired
	public GameCollectionController(UserGameCollectionService userGameCollectionService) {
		this.userGameCollectionService = userGameCollectionService;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public UserGameCollectionDto getGameCollectionByUserId(@PathVariable Long userId) throws NoSuchElementInDatabaseException {
		return userGameCollectionService.getUserGameCollection(userId);
	}

	@RequestMapping(value = "/general", method = RequestMethod.GET)
	public List<Game> getGeneralGameCollection() {
		return userGameCollectionService.getGeneralGameCollection();
	}

	@RequestMapping(value = "/find-by-params", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Game> getListOfGamesFilteredByGivenParams(
			@RequestBody FindGameByParamsRequestDto findGameByParamsRequestDto) {
		return userGameCollectionService.findGameByParams(findGameByParamsRequestDto);
	}

	@RequestMapping(value = "/create-new-game", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addNewGameToGeneralCollection(@RequestBody GameDto gameDto) {
		userGameCollectionService.addNewGameToGeneralCollection(gameDto);
	}

	@RequestMapping(value = "/add-game", method = RequestMethod.PUT)
	public void addGameToUserCollection(@RequestParam Long userId, @RequestParam Long gameId)
			throws NoSuchElementInDatabaseException {
		userGameCollectionService.addGameToUserCollection(userId, gameId);
	}
	
	@RequestMapping(value = "/delete-game", method = RequestMethod.DELETE)
	public Game deleteGameFromUserCollection(@RequestParam Long userId, @RequestParam Long gameId)
			throws NoSuchElementInDatabaseException {
		return userGameCollectionService.removeGameFromUserCollection(userId, gameId);
	}

}
