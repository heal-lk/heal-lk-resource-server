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
import org.hibernate.exception.ConstraintViolationException;

import org.aum.system.Logger;
import org.aum.fhir3.model.Patient;
import org.aum.fhir3.model.Identifier;
import org.aum.fhir3.model.Test;
import org.aum.fhir3.repository.PatientRepository;
import org.aum.fhir3.repository.TestRepository;
import org.aum.fhir3.outcome.OperationOutcome;


@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private TestRepository testRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Patient patient){
        try {
            Patient tmp = patientRepository.findOneRegisteredPatientBy_identifier(patient.get_identifier());
            if(tmp == null) {
                patient = patientRepository.save(patient);
                return new ResponseEntity<>(patient, HttpStatus.OK);
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

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> read(@RequestBody Identifier identifier){
        //TODO
        Patient tmp = patientRepository.findOneRegisteredPatientBy_identifier(identifier);
        if(tmp != null){
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        }
        //TODO
        return new ResponseEntity<>(OperationOutcome.RecordNotFound(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(){
        return "updating a patient object";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(){
        return "deleting a patient object";
    }

    @RequestMapping(value="/sample/{parameter}", method = RequestMethod.GET)
    public String sample(@PathVariable String parameter){
    	return "This is the parameter " + parameter;
    }
    
}
