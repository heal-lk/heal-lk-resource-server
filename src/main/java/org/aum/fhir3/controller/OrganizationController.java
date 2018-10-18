package org.aum.fhir3.controller;


import org.aum.fhir3.model.base.entities.OrganizationContact;
import org.aum.fhir3.model.base.general.Address;
import org.aum.fhir3.model.base.general.ContactPoint;
import org.aum.fhir3.model.base.general.Period;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.aum.fhir3.repository.base.entities.OrganizationRepository;
import org.aum.fhir3.model.base.entities.Organization;
import org.aum.system.Logger;
import org.aum.fhir3.outcome.OperationOutcome;

import java.util.Date;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {
    @Autowired
    OrganizationRepository organizationRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Organization organization){
        try {
            Organization tmp = organizationRepository.findOneRegisteredOrganizationByName(organization.getName());
            if(tmp == null) {
                organization = organizationRepository.save(organization);
                return new ResponseEntity<>(organization, HttpStatus.OK);
            }else{
                //TODO
                return new ResponseEntity<>(OperationOutcome.RecordExists(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch(Exception e){
            //TODO
            Logger.LogError(e.getMessage());
            return new ResponseEntity<>(OperationOutcome.InternalError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //TODO this should be unique organization registation code not name;
    @RequestMapping(value = "/read/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> read(@PathVariable String name){
        Organization tmp = organizationRepository.findOneRegisteredOrganizationByName(name);
        if(tmp != null){
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        }
        //TODO
        return new ResponseEntity<>(OperationOutcome.RecordNotFound(), HttpStatus.OK);
    }

    @RequestMapping(value="/sample/{parameter}", method = RequestMethod.GET,  produces = "application/json")
    public ResponseEntity<?> sample(@PathVariable String parameter) {
        Organization organization = new Organization();
        organization.setActive(true);
        organization.setName("Delmon Hospital");
        organization.setAlias("DELMO");
        ContactPoint contactPoint = new ContactPoint();
        contactPoint.setSystem("phone");
        contactPoint.setValue("0094779867098");
        contactPoint.setUse("home");
        contactPoint.setRank("1");
        organization.setTelecom(contactPoint);
        Address address = new Address();
        address.setUse("work");
        address.setType("postal");
        address.setText("Villa Residence");
        address.setLine("No 6 32nd Lane");
        address.setCity("Colombo");
        address.setDistrict("Colombo");
        address.setProvince("Western");
        address.setPostalCode("00600");
        address.setCountry("Sri Lanka");
        Period period = new Period();
        period.setStart(new Date());
        period.setEnd(new Date());
        address.setPeriod(period);
        organization.setAddress(address);
        OrganizationContact organizationContact = new OrganizationContact();
        organizationContact.setFirstName("Guru");
        organizationContact.setLastName("Moorthy");
        organizationContact.setTelecom(contactPoint);
        organizationContact.setAddress(address);
        organization.setContact(organizationContact);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

}
