package org.aum.fhir3.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.aum.fhir3.repository.entities.OrganizationRepository;
import org.aum.fhir3.model.entities.Organization;
import org.aum.system.Logger;
import org.aum.fhir3.outcome.OperationOutcome;

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

}
