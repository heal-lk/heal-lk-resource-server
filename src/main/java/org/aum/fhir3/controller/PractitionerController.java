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

import org.aum.fhir3.repository.individual.PractitionerRepository;
import org.aum.fhir3.model.individual.Practitioner;
import org.aum.system.Logger;
import org.aum.fhir3.outcome.OperationOutcome;

@RestController
@RequestMapping(value = "/practitioner")
public class PractitionerController {
    @Autowired
    PractitionerRepository practitionerRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Practitioner practitioner){
        try {
            Practitioner tmp = practitionerRepository.findOneRegisteredPractitionerByNic(practitioner.getNic());
            if(tmp == null) {
                practitioner = practitionerRepository.save(practitioner);
                return new ResponseEntity<>(practitioner, HttpStatus.OK);
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


    @RequestMapping(value = "/read/{nic}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> read(@PathVariable String nic){
        Practitioner tmp = practitionerRepository.findOneRegisteredPractitionerByNic(nic);
        if(tmp != null){
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        }
        //TODO
        return new ResponseEntity<>(OperationOutcome.RecordNotFound(), HttpStatus.OK);
    }
    
}
