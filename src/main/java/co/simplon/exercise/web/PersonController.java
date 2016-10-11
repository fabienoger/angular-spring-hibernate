package co.simplon.exercise.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.service.PersonService;

@RestController
@CrossOrigin
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Person> get() {
		return personService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Person post(@RequestBody Person person) {
		return personService.add(person);
	}

	/**
	 * EXERCISE 7 : Changer la base de données pour pointer sur votre MySQL
	 */

	/**
	 * EXERCISE 8 : Modifier le delete pour effacer en base de données à partir
	 * de l'id du client
	 */
	public void delete(Integer id) {

	}

	/**
	 * EXERCISE 9 : Ajouter une méthode update d'une personne en base.
	 * 
	 * ATTENTION : Pour faire un update, on doit aussi renseigner l'id pour
	 * savoir quelle personne on est en train de mettre à jour
	 */
	public void update(Person person) {

	}

}
