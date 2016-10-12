package co.simplon.exercise.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	/**
	 * EXERCISE 5 : Changer le get pour aller récuperer les données de la base
	 * de données en passant par le PersonService et le PersonRepository
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Person> get() {
		return personService.getPersons();
	}

	/**
	 * EXERCISE 6 : Changer le post pour inserer une personne en base de données
	 * de la base de données en passant par le PersonService et le
	 * PersonRepository
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Person post(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@RequestMapping(path = "/{id}")
	public @ResponseBody Person getPerson(@PathVariable int id) {
		return personService.getPerson(id);
	}
	
	@RequestMapping(path = "/name/{name}")
	public @ResponseBody List<Person> findByName(@PathVariable String name) {
		return personService.findByName(name);
	}
	
	@RequestMapping(method = RequestMethod.PUT) 
	public @ResponseBody Person put(@RequestBody Person person) {
		return personService.updatePerson(person);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE) 
	public @ResponseBody Person delete(@PathVariable int id) {
		return personService.deletePerson(id);
	}
}
