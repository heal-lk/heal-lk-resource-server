package org.aum.fhir3.repository.base.general;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.base.general.CodeableConcept;


@Repository
public interface CodeableConceptRepository extends JpaRepository<CodeableConcept, Long> {
    public CodeableConcept findOneCodeableConceptByText(String text);
}