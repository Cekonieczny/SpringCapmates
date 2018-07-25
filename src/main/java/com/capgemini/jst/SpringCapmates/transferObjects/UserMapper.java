package com.capgemini.jst.SpringCapmates.transferObjects;

import org.springframework.stereotype.Component;

import com.capgemini.jst.SpringCapmates.data.User;
@Component
public class UserMapper {
	
	public UserGameCollectionDto mapUserToUserGameCollectionDto(User user){
		UserGameCollectionDto userGameCollectionDto= new UserGameCollectionDto(user.getId(),user.getGameCollection());
		return userGameCollectionDto;
	}

}
