package co.simplon.exercise.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.service.PersonService;

@Controller

public class JspController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping(path = "/person")
	public @ResponseBody ModelAndView getPerson(@RequestParam int id, ModelMap model) {
		Person person = personService.getPerson(id);
		model.addAttribute("person", person);
		return new ModelAndView("person", model);
	}
	
	@RequestMapping(path = "/persons")
	public @ResponseBody ModelAndView getPersons(ModelMap model) {
		List <Person> persons = personService.getPersons();
		model.addAttribute("persons", persons);
		return new ModelAndView("persons", model);
	}
	
	@RequestMapping(path = "/addPerson")
	public @ResponseBody ModelAndView getPersons(@RequestParam String name, @RequestParam String surname, ModelMap model) {
		personService.addPerson(new Person(name, surname));
		return new ModelAndView("redirect:/persons");
	}
	
	@RequestMapping(path = "/deletePerson")
	public @ResponseBody ModelAndView deletePerson(@RequestParam int id, ModelMap model) {
		personService.deletePerson(id);
		return new ModelAndView("redirect:/persons");
	}
}
