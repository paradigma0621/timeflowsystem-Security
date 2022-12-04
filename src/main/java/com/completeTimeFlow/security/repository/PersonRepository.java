package com.completeTimeFlow.security.repository;

import com.completeTimeFlow.security.server.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);

}
