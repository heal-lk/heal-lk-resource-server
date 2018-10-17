package org.aum.fhir3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.PractitionerQualification;


@Repository
public interface PractitionerQualificationRepository extends JpaRepository<PractitionerQualification, Long> {

}