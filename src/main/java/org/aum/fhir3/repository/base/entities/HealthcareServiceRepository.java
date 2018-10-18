package org.aum.fhir3.repository.base.entities;


import org.aum.fhir3.model.base.entities.HealthcareService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HealthcareServiceRepository extends JpaRepository<HealthcareService, Long> {
}