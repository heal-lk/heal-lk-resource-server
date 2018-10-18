package org.aum.fhir3.repository.base.general;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.Test;


@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}