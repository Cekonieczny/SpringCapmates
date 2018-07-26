package com.capgemini.jst.SpringCapmates.test;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jst.SpringCapmates.data.Game;
import com.capgemini.jst.SpringCapmates.data.User;
import com.capgemini.jst.SpringCapmates.repositories.UserDao;
import com.capgemini.jst.SpringCapmates.services.UserProfileService;
import com.capgemini.jst.SpringCapmates.transferObjects.UserProfileDto;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProfileServiceTest {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserDao userDao;
	
	@Test public void getUserProfileTest(){
		//given
		List<Game> gameCollection2 = new LinkedList<>();
		gameCollection2.add(new Game(1L, "Agricola", 1, 4));
		gameCollection2.add(new Game(5L, "Scythe", 2, 4));
		gameCollection2.add(new Game(4L, "Gaia Project", 2, 5));
		UserProfileDto givenUserProfile = new UserProfileDto("Jan", "Nowak", "jan.nowak@abc.com", "hfdfd123", "motto41");
		
		//when
		UserProfileDto userProfileDto = userProfileService.getUserProfile(2L);
		
		//then
		assertEquals(givenUserProfile.geteMailAddress(),userProfileDto.geteMailAddress());
		assertEquals(givenUserProfile.getUserFirstName(),userProfileDto.getUserFirstName());
		assertEquals(givenUserProfile.getUserLastName(), userProfileDto.getUserLastName());
		assertEquals(givenUserProfile.getPassword(), userProfileDto.getPassword());
		assertEquals(givenUserProfile.getLifeMotto(),userProfileDto.getLifeMotto());
	}
	
	@Test public void changeUserFirstNameTest(){
		//given
		Long userId = 2L;
		String newUserFirstName = "Bohdan";
		String oldUserFirstName = "Jan";
		//when
		assertEquals(oldUserFirstName,userDao.find(userId).getUserFirstName());
		userProfileService.changeUserFirstName(userId, newUserFirstName);
		//then
		assertEquals(newUserFirstName,userDao.find(userId).getUserFirstName());
	}
	
	@Test public void changeUserLastNameTest(){
		//given
		Long userId = 2L;
		String newUserLastName = "Kmicic";
		String oldUserLastName = "Nowak";
		//when
		assertEquals(oldUserLastName,userDao.find(userId).getUserLastName());
		userProfileService.changeUserLastName(userId, newUserLastName);
		//then
		assertEquals(newUserLastName,userDao.find(userId).getUserLastName());
	}
	
	@Test public void changeUserEMailAddressTest(){
		//given
		Long userId = 2L;
		String newUserEMail = "nowak.jan@abc.com";
		String oldUserEMail = "jan.nowak@abc.com";
		//when
		assertEquals(oldUserEMail,userDao.find(userId).getEMailAddress());
		userProfileService.changeUserEmail(userId, newUserEMail); 
		//then
		assertEquals(newUserEMail,userDao.find(userId).getEMailAddress());
	}
	
	@Test public void changeUserPassword(){
		//given
		Long userId = 2L;
		String newUserPassword = "haslo";
		String oldUserPassword = "hfdfd123";
		//when
		assertEquals(oldUserPassword,userDao.find(userId).getPassword());
		userProfileService.changeUserPassword(userId, newUserPassword);
		//then
		assertEquals(newUserPassword,userDao.find(userId).getPassword());
	}
	
	@Test public void changeLifeMotto(){
		//given
		Long userId = 9L;
		String newUserMotto = "mottoMotto";
		String oldUserMotto = "motto51";
		//when
		assertEquals(oldUserMotto,userDao.find(userId).getLifeMotto());
		userProfileService.changeUserLifeMotto(userId, newUserMotto);
		//then
		assertEquals(newUserMotto,userDao.find(userId).getLifeMotto());
	}
}
