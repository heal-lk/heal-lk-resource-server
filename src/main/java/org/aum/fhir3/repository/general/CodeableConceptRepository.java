package org.aum.fhir3.repository.general;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.general.CodeableConcept;


@Repository
public interface CodeableConceptRepository extends JpaRepository<CodeableConcept, Long> {

}