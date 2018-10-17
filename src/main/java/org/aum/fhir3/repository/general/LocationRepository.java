package org.aum.fhir3.repository.entities;


import org.aum.fhir3.model.entities.HealthcareService;
import org.aum.fhir3.model.general.Location;
import org.aum.fhir3.model.individual.PractitionerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LocationRoleRepository extends JpaRepository<Location, Long> {
}