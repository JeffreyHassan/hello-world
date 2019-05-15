package com.jeff.test.repository;

import com.jeff.test.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByFullName(String name);
}
