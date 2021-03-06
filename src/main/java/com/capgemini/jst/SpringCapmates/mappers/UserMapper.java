package com.capgemini.jst.SpringCapmates.mappers;

import org.springframework.stereotype.Component;
import com.capgemini.jst.SpringCapmates.data.User;
import com.capgemini.jst.SpringCapmates.transferObjects.UserGameCollectionDto;
import com.capgemini.jst.SpringCapmates.transferObjects.UserProfileDto;

@Component
public class UserMapper {

	public UserGameCollectionDto mapUserToUserGameCollectionDto(User user) {
		UserGameCollectionDto userGameCollectionDto = new UserGameCollectionDto(user.getUserId(), user.getGameCollection());
		return userGameCollectionDto;
	}

	public User mapUserGameCollectionDtoToUser(UserGameCollectionDto userGameCollectionDto, User user) {
		User newUser = user;
		newUser.setGameCollection(userGameCollectionDto.getGameCollection());
		newUser.setUserId(userGameCollectionDto.getUserId());
		return newUser;
	}

	public UserProfileDto mapUserToUserProfileDto(User user) {
		UserProfileDto userProfileDto = new UserProfileDto(user.getUserFirstName(), user.getUserLastName(),user.getEMailAddress(),
				user.getPassword(), user.getLifeMotto());
		return userProfileDto;
	}
	
	public User mapUserProfileDtoToUser(UserProfileDto userProfileDto,User user) {
		User newUser = user;
		newUser.setUserFirstName(userProfileDto.getUserFirstName());
		return user;
	}

}
