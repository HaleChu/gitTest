package pers.god.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import pers.god.demo.jpa.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String>, QueryDslPredicateExecutor<Person> {

}
