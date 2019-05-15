package com.jeff.test.rest;

import com.jeff.test.model.Person;
import com.jeff.test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Person>> getPersonsByFullName(@PathVariable("name") String name) {
        List<Person> personList = personRepository.findByFullName(name);
        return ResponseEntity.ok(personList);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        return ResponseEntity.ok(people);
    }

    @RequestMapping(value = "/createRandom/{name}/{age}", method = RequestMethod.GET)
    public ResponseEntity<Person> createRandomPerson(
            @PathVariable(value="name") String name, @PathVariable(value = "age") Integer age) {
        Person person = new Person(name,age);
        Person savedPerson = personRepository.save(person);

        return ResponseEntity.ok(savedPerson);
    }
}
