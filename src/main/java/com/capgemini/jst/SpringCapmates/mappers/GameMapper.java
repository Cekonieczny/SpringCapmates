package com.capgemini.jst.SpringCapmates.mappers;
import org.springframework.stereotype.Component;
import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.transferObjects.GameDto;

@Component
public class GameMapper {

	public GameDto mapGameToGameDto(Game game) {
		GameDto gameDto = new GameDto(game.getGameName(), game.getMinimalNumberOfPlayers(),
				game.getMaximalNumberOfPlayers());
		return gameDto;
	}

	public Game mapGameDtoToGame(GameDto gameDto,Game game) {
		Game newGame = new Game(game.getGameId(),gameDto.getGameName(),gameDto.getMinimalNumberOfPlayers(),gameDto.getMaximalNumberOfPlayers());
		return newGame;
	}

}
