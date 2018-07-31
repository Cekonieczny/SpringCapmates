package com.capgemini.jst.SpringCapmates.test.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.LinkedList;
import java.util.List;

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
		Game expectedGame = new Game("Agricola", 1, 4);
		List<Game> list = new LinkedList<>();
		list.add(expectedGame);

		Mockito.when((userGameCollectionService.findGamesByParams(Mockito.any()))).thenReturn(list);

		// when
		ResultActions resultActions = mockMvc.perform(post("/user/game-collection/find-by-params")
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
		List<Game> list = new LinkedList<>();
		list.add(new Game("Civilization", 2, 4));
		list.add(new Game("Scythe", 2, 5));
		list.add(new Game("Project Gaia", 2, 5));
		list.add(new Game("Gloomhaven", 2, 4));

		Mockito.when((userGameCollectionService.findGamesByParams(Mockito.any()))).thenReturn(list);

		// when
		ResultActions resultActions = mockMvc.perform(post("/user/game-collection/find-by-params")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(mockRequestBodyAsString));

		// then
		resultActions.andExpect(jsonPath("$[0].gameId").value(list.get(0).getGameId()));
		resultActions.andExpect(jsonPath("$[0].gameName").value(list.get(0).getGameName()));
		resultActions.andExpect(jsonPath("$[0].minimalNumberOfPlayers").value(list.get(0).getMinimalNumberOfPlayers()));
		resultActions.andExpect(jsonPath("$[0].maximalNumberOfPlayers").value(list.get(0).getMaximalNumberOfPlayers()));
		resultActions.andExpect(jsonPath("$", hasSize(4)));

	}

	@Test
	public void shouldGetGameCollectionByUserId() throws Exception {
		// given
		List<Game> list = new LinkedList<>();
		UserGameCollectionDto userGameCollectionDto = new UserGameCollectionDto();
		list.add(new Game(1L, "Agricola", 1, 4));
		list.add(new Game(2L, "Gloomhaven", 2, 4));
		list.add(new Game(3L, "Chaos in The Old World", 2, 5));
		list.add(new Game(4L, "Project Gaia", 1, 4));
		Long userId = 213L;
		userGameCollectionDto.setGameCollection(list);
		userGameCollectionDto.setUserId(userId);

		Mockito.when((userGameCollectionService.getUserGameCollection(userId))).thenReturn(userGameCollectionDto);

		// when
		ResultActions resultActions = mockMvc.perform(get("/user/game-collection/213"));

		// then
		resultActions.andExpect(jsonPath("userId").value(userId));
		resultActions.andExpect(jsonPath("$.gameCollection", hasSize(4)));
		resultActions.andExpect(jsonPath("$.gameCollection[1].gameId").value("2"));
		resultActions.andExpect(jsonPath("$.gameCollection[2].gameName").value("Chaos in The Old World"));
		resultActions.andExpect(jsonPath("$.gameCollection[3].gameName").value("Project Gaia"));
		resultActions.andExpect(jsonPath("$.gameCollection[3].minimalNumberOfPlayers").value("1"));
		resultActions.andExpect(jsonPath("$.gameCollection[3].maximalNumberOfPlayers").value("4"));
	}

}
