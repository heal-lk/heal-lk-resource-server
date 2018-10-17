package org.aum.fhir3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.Patient;
import org.aum.fhir3.model.Identifier;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Patient findOneRegisteredPatientBy_identifier(Identifier identifier);
}
