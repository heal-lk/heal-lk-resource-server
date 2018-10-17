package org.aum.fhir3.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.OrganizationContact;


@Repository
public interface OrganizationContactRepository extends JpaRepository<OrganizationContact, Long> {

}