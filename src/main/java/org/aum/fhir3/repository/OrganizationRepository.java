package org.aum.fhir3.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.Organization;


@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    public Organization findOneRegisteredOrganizationBy_name(String name);
}