package com.capgemini.jst.SpringCapmates.test.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;
import com.capgemini.jst.SpringCapmates.transferObjects.UserGameCollectionDto;
import com.capgemini.jst.SpringCapmates.SpringCapmatesApplication;
import com.capgemini.jst.SpringCapmates.controllers.GameCollectionController;
import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.services.UserGameCollectionService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringCapmatesApplication.class)
@WebAppConfiguration
public class UserGameCollectionControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Mock
	private UserGameCollectionService userGameCollectionService;

	@Autowired
	private GameCollectionController gameCollectionController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(userGameCollectionService);
		Mockito.reset(userGameCollectionService);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		ReflectionTestUtils.setField(gameCollectionController, "userGameCollectionService", userGameCollectionService);
	}

	@Test
	public void shouldGenerateListOfGamesWithFullBody() throws Exception {
		// given
		String mockRequestBodyAsString = "{\"gameNameLike\":\"Aicola\",\"minimalNumberOfPlayers\":\"1\",\"maximalNumberOfPlayers\":\"4\"}";
		Game expectedGame = new Game(1L, "Agricola", 1, 4);
		List<Game> list = new LinkedList<>();
		list.add(expectedGame);

		Mockito.when((userGameCollectionService.findGamesByParams(Mockito.any()))).thenReturn(list);

		// when
		ResultActions resultActions = mockMvc.perform(post("/user/game-collection/general/by-params")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(mockRequestBodyAsString));

		// then
		resultActions.andExpect(jsonPath("$[0].gameId").value(expectedGame.getGameId()));
		resultActions.andExpect(jsonPath("$[0].gameName").value(expectedGame.getGameName()));
		resultActions
				.andExpect(jsonPath("$[0].minimalNumberOfPlayers").value(expectedGame.getMinimalNumberOfPlayers()));
		resultActions
				.andExpect(jsonPath("$[0].maximalNumberOfPlayers").value(expectedGame.getMaximalNumberOfPlayers()));
	}

	@Test
	public void shouldGenerateListOfGamesWithOneParamOnly() throws Exception {
		// given
		String mockRequestBodyAsString = "{\"minimalNumberOfPlayers\":\"2\"}";
		List<Game> listOfGames = generateListOfGames();

		Mockito.when((userGameCollectionService.findGamesByParams(Mockito.any()))).thenReturn(listOfGames);

		// when
		ResultActions resultActions = mockMvc.perform(post("/user/game-collection/general/by-params")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(mockRequestBodyAsString));

		// then
		resultActions.andExpect(jsonPath("$[0].gameId").value(listOfGames.get(0).getGameId()));
		resultActions.andExpect(jsonPath("$[0].gameName").value(listOfGames.get(0).getGameName()));
		resultActions.andExpect(
				jsonPath("$[0].minimalNumberOfPlayers").value(listOfGames.get(0).getMinimalNumberOfPlayers()));
		resultActions.andExpect(
				jsonPath("$[0].maximalNumberOfPlayers").value(listOfGames.get(0).getMaximalNumberOfPlayers()));
		resultActions.andExpect(jsonPath("$", hasSize(5)));

	}

	@Test
	public void shouldGetGameCollectionByUserId() throws Exception {
		// given
		Long userId = 213L;
		List<Game> listOfGames = generateListOfGames();
		UserGameCollectionDto userGameCollectionDto = new UserGameCollectionDto();
		userGameCollectionDto.setGameCollection(listOfGames);
		userGameCollectionDto.setUserId(userId);

		Mockito.when((userGameCollectionService.getUserGameCollection(userId))).thenReturn(userGameCollectionDto);

		// when
		ResultActions resultActions = mockMvc.perform(get("/user/game-collection/213"));

		// then
		resultActions.andExpect(jsonPath("userId").value(userId));
		resultActions.andExpect(jsonPath("$.gameCollection", hasSize(5)));
		resultActions.andExpect(jsonPath("$.gameCollection[1].gameId").value("2"));
		resultActions.andExpect(jsonPath("$.gameCollection[2].gameName").value("Chaos in The Old World"));
		resultActions.andExpect(jsonPath("$.gameCollection[3].gameName").value("Project Gaia"));
		resultActions.andExpect(jsonPath("$.gameCollection[3].minimalNumberOfPlayers").value("1"));
		resultActions.andExpect(jsonPath("$.gameCollection[3].maximalNumberOfPlayers").value("4"));
	}

	@Test
	public void shouldGetGeneralCollection() throws Exception {
		// given
		List<Game> listOfGames = generateListOfGames();

		Mockito.when((userGameCollectionService.getGeneralGameCollection())).thenReturn(listOfGames);

		// when
		ResultActions resultActions = mockMvc.perform(get("/user/game-collection/general"));

		// then

		resultActions.andExpect(jsonPath("$[1].gameId").value("2"));
		resultActions.andExpect(jsonPath("$[2].gameName").value("Chaos in The Old World"));
		resultActions.andExpect(jsonPath("$[3].gameName").value("Project Gaia"));
		resultActions.andExpect(jsonPath("$[3].minimalNumberOfPlayers").value("1"));
		resultActions.andExpect(jsonPath("$[3].maximalNumberOfPlayers").value("4"));
		resultActions.andExpect(jsonPath("$[4].gameName").value("Civilization"));
		resultActions.andExpect(jsonPath("$", hasSize(5)));
	}

	@Test
	public void shouldAddNewGameToGeneralCollection() throws Exception {
		// given
		String mockRequestBodyAsString = "{\"gameName\": \"Chaos in the old world\",\"minimalNumberOfPlayers\": 2,\"maximalNumberOfPlayers\": 5}";
		
		Mockito.doNothing().when(userGameCollectionService).addNewGameToGeneralCollection(Mockito.any());

		// when
		ResultActions resultActions = mockMvc.perform(post("/user/game-collection/game")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(mockRequestBodyAsString));

		// then
		resultActions.andExpect(status().isOk());
		verify(userGameCollectionService, times(1)).addNewGameToGeneralCollection(Mockito.any());
	    verifyNoMoreInteractions(userGameCollectionService);
		
	}
	
	@Test
	public void shouldAddNewGameToUserCollection() throws Exception {
		// given
		Mockito.doNothing().when(userGameCollectionService).addGameToUserCollection(Mockito.any(), Mockito.any());

		// when
		ResultActions resultActions = mockMvc.perform(put("/user/game-collection/game?userId=7&gameId=5"));

		// then
		resultActions.andExpect(status().isOk());
		verify(userGameCollectionService, times(1)).addGameToUserCollection(Mockito.any(), Mockito.any());
	    verifyNoMoreInteractions(userGameCollectionService);
		
	}
	
	@Test
	public void shouldDeleteGameFromUserCollection() throws Exception {
		// given
		Game game = new Game(1L,"Agricola",1,4);
		Mockito.when((userGameCollectionService.removeGameFromUserCollection(Mockito.any(), Mockito.any()))).thenReturn(game);

		// when
		ResultActions resultActions = mockMvc.perform(delete("/user/game-collection/game?userId=7&gameId=5"));

		// then
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(jsonPath("gameId").value("1"));
		resultActions.andExpect(jsonPath("gameName").value("Agricola"));
		resultActions.andExpect(jsonPath("minimalNumberOfPlayers").value("1"));
		resultActions.andExpect(jsonPath("maximalNumberOfPlayers").value("4"));
	}

	private List<Game> generateListOfGames() {
		List<Game> listOfGames = new LinkedList<>();
		listOfGames.add(new Game(1L, "Agricola", 1, 4));
		listOfGames.add(new Game(2L, "Gloomhaven", 2, 4));
		listOfGames.add(new Game(3L, "Chaos in The Old World", 2, 5));
		listOfGames.add(new Game(4L, "Project Gaia", 1, 4));
		listOfGames.add(new Game(5L, "Civilization", 2, 4));
		return listOfGames;
	}

}
