package org.aum.fhir3.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.CodeableConcept;


@Repository
public interface CodeableConceptRepository extends JpaRepository<CodeableConcept, Long> {

}