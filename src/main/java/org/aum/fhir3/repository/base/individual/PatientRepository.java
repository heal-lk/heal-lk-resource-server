package org.aum.fhir3.repository.base.individual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import org.aum.fhir3.model.base.individual.Patient;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Patient findPatientById(Long id);
    public List<Patient> findAll();
}
