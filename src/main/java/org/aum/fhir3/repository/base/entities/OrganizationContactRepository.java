package org.aum.fhir3.repository.base.entities;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.base.entities.OrganizationContact;


@Repository
public interface OrganizationContactRepository extends JpaRepository<OrganizationContact, Long> {

}