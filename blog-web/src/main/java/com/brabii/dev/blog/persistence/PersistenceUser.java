package com.brabii.dev.blog.persistence;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.brabii.dev.blog.entities.User;
import com.brabii.dev.blog.metier.CriterePersistence;
import com.brabii.dev.blog.metier.CritereRecherche;
import com.brabii.dev.blog.util.CriteresPersistenceUtil;

@Transactional
public class PersistenceUser implements InterfacePersistenceUser {
//	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserById(Long id) {
		User user = new User();
//		user.setIdUser(1);
		user.setFirstName("rabie");
		user.setLastName("belhaj");
		user.setEmail("rabie@gmx.com");
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		User user1 = new User();
		user1.setIdUser(1);
		user1.setFirstName("rabie1");
		user1.setLastName("belhaj1");
		user1.setEmail("rabie1@gmx.com");
		User user2 = new User();
		user2.setIdUser(1);
		user2.setFirstName("rabie2");
		user2.setLastName("belhaj2");
		user2.setEmail("rabie2@gmx.com");
		List<User> users = Arrays.asList(user1, user2);
		return users;
	}

	@Override
	public Long getNombreTotalUsers(CritereRecherche critereRecherche) {

		return null;
	}

	public Criteria buildRechercheCriteriaUser(CritereRecherche critereRecherche) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class, "user");
		detachedCriteria.setProjection(Projections.distinct(Projections.property("user.idUser")));

		if (critereRecherche.contains(CriteresPersistenceUtil.RECHERCHE_UTILISATEUR_ID)) {
			CriterePersistence critere = critereRecherche
					.foundCriterePersistence(CriteresPersistenceUtil.RECHERCHE_UTILISATEUR_ID);
			critere.addDetachedCriteriaRestrictions(detachedCriteria, CriteresPersistenceUtil.RECHERCHE_UTILISATEUR_ID);
		}
		if (critereRecherche.contains(CriteresPersistenceUtil.RECHERCHE_UTILISATEUR_NOM)) {
			CriterePersistence critere = critereRecherche
					.foundCriterePersistence(CriteresPersistenceUtil.RECHERCHE_UTILISATEUR_NOM);
			critere.addDetachedCriteriaRestrictions(detachedCriteria,
					CriteresPersistenceUtil.RECHERCHE_UTILISATEUR_NOM);
		}
		if (critereRecherche.contains(CriteresPersistenceUtil.RECHERCHE_UTILISATEUR_PRENOM)) {
			CriterePersistence critere = critereRecherche
					.foundCriterePersistence(CriteresPersistenceUtil.RECHERCHE_UTILISATEUR_PRENOM);
			critere.addDetachedCriteriaRestrictions(detachedCriteria,
					CriteresPersistenceUtil.RECHERCHE_UTILISATEUR_PRENOM);
		}

		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		return null;
	}

	@Override
	public Integer saveUser(User user) {

		return (Integer) this.sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void removeUserById(Long id) {

	}

	@Override
	public void removeUserByEmail(String email) {

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
