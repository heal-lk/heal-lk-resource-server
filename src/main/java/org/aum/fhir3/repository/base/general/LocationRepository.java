package org.aum.fhir3.repository.base.general;


import org.aum.fhir3.model.base.general.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}