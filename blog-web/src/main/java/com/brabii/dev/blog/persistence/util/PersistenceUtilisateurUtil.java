package com.brabii.dev.blog.persistence.util;

import java.util.Date;

import com.brabii.dev.blog.entities.User;
import com.brabii.dev.blog.persistence.PersistenceUser;

public class PersistenceUtilisateurUtil {

	public static void main(String[] args) {
		User user = new User();
		user.setIdUser(5);
		user.setFirstName("test firstname");
		user.setLastName("test lastname");
		user.setEmail("email");
		user.setPassword("pasword");
		user.setRegisteredAt(new Date());
		PersistenceUser persistenceUser = new PersistenceUser();
		Integer integer = persistenceUser.saveUser(user);
	}
}
