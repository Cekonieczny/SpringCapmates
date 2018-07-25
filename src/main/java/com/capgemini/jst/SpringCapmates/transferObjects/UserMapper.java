package com.capgemini.jst.SpringCapmates.transferObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.jst.SpringCapmates.data.User;
import com.capgemini.jst.SpringCapmates.repositories.UserDao;

@Component
public class UserMapper {
	private final UserDao userDao;

	@Autowired
	public UserMapper(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserGameCollectionDto mapUserToUserGameCollectionDto(Long userId) {
		UserGameCollectionDto userGameCollectionDto = new UserGameCollectionDto(userId,
				userDao.find(userId).getGameCollection());
		return userGameCollectionDto;
	}

	public User mapUserGameCollectionDtoToUser(UserGameCollectionDto userGameCollectionDto) {
		User user = userDao.find(userGameCollectionDto.getUserId());
		user.setGameCollection(userGameCollectionDto.getGameCollection());
		return user;
	}
	

	public UserProfileDto mapUserToUserProfileDto(User user) {
		UserProfileDto userProfileDto = new UserProfileDto();
		return userProfileDto;
	}

}
