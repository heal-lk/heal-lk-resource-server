package org.aum.fhir3.repository.general;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.general.Coding;


@Repository
public interface CodingRepository extends JpaRepository<Coding, Long> {

}