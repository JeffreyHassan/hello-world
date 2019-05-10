package com.jeff.test.rest;

import com.jeff.test.model.Person;
import com.jeff.test.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("/")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        return ResponseEntity.ok(people);
    }

    @RequestMapping("/createRandom/{name}/{age}")
    public ResponseEntity<Person> createRandomPerson(
            @PathVariable(value="name") String name, @PathVariable(value = "age") Integer age) {
        Person person = new Person(name,age);
        Person savedPerson = personRepository.save(person);

        return ResponseEntity.ok(savedPerson);
    }
}
