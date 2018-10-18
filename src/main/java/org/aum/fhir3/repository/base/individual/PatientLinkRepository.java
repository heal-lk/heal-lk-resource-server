package org.aum.fhir3.repository.base.individual;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.base.individual.PatientLink;


@Repository
public interface PatientLinkRepository extends JpaRepository<PatientLink, Long> {

}