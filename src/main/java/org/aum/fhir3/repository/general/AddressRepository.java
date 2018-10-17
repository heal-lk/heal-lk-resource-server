package org.aum.fhir3.repository.general;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.aum.fhir3.model.general.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}