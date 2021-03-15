package com.brabii.dev.blog.gestionnaire;

import java.util.List;

import com.brabii.dev.blog.PaginationWithHeader;
import com.brabii.dev.blog.entities.User;
import com.brabii.dev.blog.metier.CritereRecherche;
import com.brabii.dev.blog.metier.CritereTrie;
import com.brabii.dev.blog.persistence.InterfacePersistenceUser;

public class GestionnaireAdministration {


//	@Autowired
	private InterfacePersistenceUser persistUser;

	public PaginationWithHeader rechercheUser(Integer page, Integer nombreTotalEnregistrements,
			CritereRecherche critereRecherche, CritereTrie critereTrie) {
		PaginationWithHeader pagination = new PaginationWithHeader();
		pagination.setNombreTotalEnregistrements(nombreTotalEnregistrements);
		pagination.setRecherche(critereRecherche.convertToMap());
		pagination.setSortBy(critereRecherche.convertToMap());

		Long totalUsers = this.persistUser.getNombreTotalUsers(critereRecherche);
		return null;
	}

	public User getUser(Long userId) {
		if (userId != null) {
			return persistUser.getUserById(userId);
		}
		return null;
	}

	public List<User> allUsers() {
		return this.persistUser.getAllUsers();
	}

	public InterfacePersistenceUser getPersistUser() {
		return persistUser;
	}

	public void setPersistUser(InterfacePersistenceUser persistUser) {
		this.persistUser = persistUser;
	}
}
