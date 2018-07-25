package com.capgemini.jst.transferObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.jst.data.User;
@Component
public class UserMapper {
	
	public UserGameCollectionDto mapUserToUserGameCollectionDto(User user){
		UserGameCollectionDto userGameCollectionDto= new UserGameCollectionDto(user.getId(),user.getGameCollection());
		return userGameCollectionDto;
	}

}
