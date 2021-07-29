package com.syncretis.repository;

import com.syncretis.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findById(long id);

    List<Person> findByIdBetween(long firstId, long lastId);

}
