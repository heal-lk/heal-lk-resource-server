package org.aum.fhir3.repository.base.individual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.base.individual.Practitioner;
import java.util.List;

@Repository
public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {
    public Practitioner findPractitionerById(Long id);
    public List<Practitioner> findAll();
}