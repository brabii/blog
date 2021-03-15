package com.brabii.dev.blog.persistence;

import java.util.List;

import com.brabii.dev.blog.entities.User;
import com.brabii.dev.blog.metier.CritereRecherche;

// TODO : je le déclare comme un bean
public interface InterfacePersistenceUser {

	public User getUserById(Long id);

	public List<User> getAllUsers();

	public User getUserByEmail(String email);

	// ceci save et update
	public Integer saveUser(User user);

	public void removeUserById(Long id);

	public void removeUserByEmail(String email);

	public Long getNombreTotalUsers(CritereRecherche critereRecherche);
}
