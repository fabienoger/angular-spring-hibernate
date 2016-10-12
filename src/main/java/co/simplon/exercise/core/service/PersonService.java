package co.simplon.exercise.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.repository.PersonRepository;

@Repository
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public List<Person> getPersons() {
		return personRepository.findAll();
	}
	
	public Person addPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPerson(int id) {
		return personRepository.findOne(id);
	}
	
	public List<Person> findByName(String name) {
		Person p = new Person(name, null);
		return personRepository.findAll(Example.of(p));
	}
	
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person deletePerson(int id) {
		personRepository.delete(id);
		return null;
	}
}