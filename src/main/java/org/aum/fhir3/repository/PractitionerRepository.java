package org.aum.fhir3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.Practitioner;


@Repository
public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {
    public Practitioner findOneRegisteredPractitionerBy_nic(String nic);
}