package com.brabii.dev.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brabii.dev.blog.PaginationWithHeader;
import com.brabii.dev.blog.entities.User;
import com.brabii.dev.blog.gestionnaire.GestionnaireAdministration;
import com.brabii.dev.blog.metier.CritereRecherche;
import com.brabii.dev.blog.metier.CritereTrie;
import com.brabii.dev.blog.metier.InterfaceJsonMapper;

@Controller
public class UserController {
	@Autowired
	private GestionnaireAdministration gestionnaireAdministration;
	@Autowired
	private InterfaceJsonMapper jsonMapper;

	@RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> readUser(@PathVariable(name = "userId") long userId) {
		User user = gestionnaireAdministration.getUser(userId);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// TODO ceci ça sera une pagination with header
//	@RequestMapping(path = "/test", method = RequestMethod.GET)
//	public ResponseEntity<User> readUsers() {
//		List<User> users = gestionnaireAdministration.allUsers();
//		if (users == null) {
//			return null;
//		}
//		return null;
//	}
	@RequestMapping(path = "/users", method = RequestMethod.GET) // TODO path à modifier
	public ResponseEntity<User> readUsers(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "enregistrement_max", required = false) Integer enregistrementMax,
			@RequestParam(value = "trie", required = false) String trie,
			@RequestParam(value = "recherche", required = false, defaultValue = "false") String recherche,
			@RequestParam(value = "entete", required = false) Boolean avecEntete) throws Exception {

		page = (page == null) ? 1 : page;
		enregistrementMax = (enregistrementMax == null) ? 10 : enregistrementMax; // TODO à revoir aprés

		trie = (trie == null) ? "{}" : trie; // va prendre en valeur asc ou desc
		recherche = (recherche == null) ? "{}" : recherche; // je ne sais pas

		Map<String, Object> mapTrie = jsonMapper.convertStringToMap(trie);
		CritereTrie critereTrie = CritereTrie.createFromMap(mapTrie);

		Map<String, Object> mapCritereRecherches = this.jsonMapper.convertStringToMap(recherche);
		CritereRecherche critereRecherche = CritereRecherche.createFromMap(mapCritereRecherches);

		PaginationWithHeader pagination = null;

		List<User> users = gestionnaireAdministration.allUsers();
		if (users == null) {
			return null;
		}
		return null;
	}

	/*******
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
