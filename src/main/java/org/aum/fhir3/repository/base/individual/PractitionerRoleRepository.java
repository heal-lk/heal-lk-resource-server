package org.aum.fhir3.repository.base.individual;


import org.aum.fhir3.model.base.individual.PractitionerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PractitionerRoleRepository extends JpaRepository<PractitionerRole, Long> {
}