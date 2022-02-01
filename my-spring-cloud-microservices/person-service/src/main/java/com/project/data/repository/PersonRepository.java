package com.project.data.repository;

import com.project.data.document.Person;

import java.util.List;

public interface PersonRepository extends BaseRepository<Person, Integer> {

    List<Person> findPersonByUsername(String userName);

}
