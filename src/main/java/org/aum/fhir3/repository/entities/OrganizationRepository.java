package org.aum.fhir3.repository.entities;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.entities.Organization;


@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    public Organization findOneRegisteredOrganizationByName(String name);
}