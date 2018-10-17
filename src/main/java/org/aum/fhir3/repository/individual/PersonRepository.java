package org.aum.fhir3.repository.individual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;    

import org.aum.fhir3.model.individual.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}