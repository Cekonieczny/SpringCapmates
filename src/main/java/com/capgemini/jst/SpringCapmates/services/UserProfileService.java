package com.capgemini.jst.SpringCapmates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.jst.SpringCapmates.transferObjects.UserProfileDto;
import com.capgemini.jst.SpringCapmates.data.User;
import com.capgemini.jst.SpringCapmates.mappers.UserMapper;
import com.capgemini.jst.SpringCapmates.repositories.UserDao;

@Service
public class UserProfileService {
	private final UserDao userDao;
	private final UserMapper userMapper;

	@Autowired
	public UserProfileService(UserDao userDao, UserMapper userMapper) {
		this.userDao = userDao;
		this.userMapper = userMapper;
	}

	public UserProfileDto getUserProfile(Long userId) {
		User user = userDao.find(userId);
		return userMapper.mapUserToUserProfileDto(user);
	}

	public User changeUserFirstName(Long userId, String newUserFirstName) {
		User user = userDao.find(userId);
		user.setUserName(newUserFirstName);
		return user;

	}

	public User changeUserLastName(Long userId, String newUserLastName) {
		User user = userDao.find(userId);
		user.setUserLastName(newUserLastName);
		return user;

	}

	public User changeUserPassword(Long userId, String newPassword) {
		User user = userDao.find(userId);
		user.setPassword(newPassword);
		return user;

	}

	public User changeUserEmail(Long userId, String newEmailAddress) {
		User user = userDao.find(userId);
		user.setEMailAddress(newEmailAddress);
		return user;

	}

	public User changeUserLifeMotto(Long userId, String newLifeMotto) {
		User user = userDao.find(userId);
		user.setLifeMotto(newLifeMotto);
		return user;

	}

}
