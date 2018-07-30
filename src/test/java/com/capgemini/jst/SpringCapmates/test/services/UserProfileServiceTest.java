package com.capgemini.jst.SpringCapmates.test.services;

import static org.junit.Assert.assertEquals;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jst.SpringCapmates.exceptions.NoSuchElementInDatabaseException;
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
	
	@Test public void getUserProfileTest() throws NoSuchElementInDatabaseException{
		//given
		UserProfileDto givenUserProfile = new UserProfileDto("Wojciech", "Truskawski", "truskawski.wojciech@abc.com","hasl13",  "motto71");
		
		//when
		UserProfileDto userProfileDto = userProfileService.getUserProfile(5L);
		
		//then
		assertEquals(givenUserProfile.geteMailAddress(),userProfileDto.geteMailAddress());
		assertEquals(givenUserProfile.getUserFirstName(),userProfileDto.getUserFirstName());
		assertEquals(givenUserProfile.getUserLastName(), userProfileDto.getUserLastName());
		assertEquals(givenUserProfile.getPassword(), userProfileDto.getPassword());
		assertEquals(givenUserProfile.getLifeMotto(),userProfileDto.getLifeMotto());
	}
	
	@Test public void changeUserFirstNameTest() throws NoSuchElementInDatabaseException{
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
	
	@Test public void changeUserLastNameTest() throws NoSuchElementInDatabaseException{
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
	
	@Test public void changeUserEMailAddressTest() throws NoSuchElementInDatabaseException{
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
	
	@Test public void changeUserPassword() throws NoSuchElementInDatabaseException{
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
	
	@Test public void changeLifeMotto() throws NoSuchElementInDatabaseException{
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
