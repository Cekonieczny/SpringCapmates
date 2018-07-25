package com.capgemini.jst.repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.capgemini.jst.data.User;

@Repository
public class UserDao {
	List<User> listOfUsers;

	private UserDao() {
		this.listOfUsers = new ArrayList<>();
	}

	public User find(Long userId) {
		while (listOfUsers.stream().iterator().hasNext()) {
			User user = listOfUsers.stream().iterator().next();
			if (user.getId().equals(userId)) {
				return user;
			}
		}
		return null;
	}

}
