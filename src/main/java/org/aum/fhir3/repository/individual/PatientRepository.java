package org.aum.fhir3.repository.individual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.individual.Patient;
import org.aum.fhir3.model.general.Identifier;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Patient findOneRegisteredPatientByNic(String nic);
}
