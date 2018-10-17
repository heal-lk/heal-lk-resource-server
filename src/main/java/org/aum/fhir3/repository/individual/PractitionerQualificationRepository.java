package org.aum.fhir3.repository.individual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.individual.PractitionerQualification;


@Repository
public interface PractitionerQualificationRepository extends JpaRepository<PractitionerQualification, Long> {

}