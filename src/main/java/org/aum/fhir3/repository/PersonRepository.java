package org.aum.fhir3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;    

import org.aum.fhir3.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}