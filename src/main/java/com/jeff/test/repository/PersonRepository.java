package com.jeff.test.repository;

import com.jeff.test.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findByFullName(String name);
}
