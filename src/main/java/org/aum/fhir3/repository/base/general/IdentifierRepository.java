package org.aum.fhir3.repository.base.general;


import org.aum.fhir3.model.base.general.CodeableConcept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.base.general.Identifier;


@Repository
public interface IdentifierRepository extends JpaRepository<Identifier, Long> {
    public Identifier findIdentifierByValue(String value);
}