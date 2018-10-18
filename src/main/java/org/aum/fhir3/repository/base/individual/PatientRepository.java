package org.aum.fhir3.repository.base.individual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.base.individual.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Patient findOneRegisteredPatientByNic(String nic);
}
