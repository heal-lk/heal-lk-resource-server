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

import org.aum.system.Logger;
import org.aum.fhir3.model.individual.Patient;
import org.aum.fhir3.model.general.Identifier;
import org.aum.fhir3.repository.individual.PatientRepository;
import org.aum.fhir3.repository.general.TestRepository;
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
            Patient tmp = patientRepository.findOneRegisteredPatientByNic(patient.getNic());
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

    @RequestMapping(value = "/read/{nic}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> read(String nic){
        Patient tmp = patientRepository.findOneRegisteredPatientByNic(nic);
        if(tmp != null){
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        }
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
    public ResponseEntity<?> sample(@PathVariable String parameter){
        Patient patient = new Patient();

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
    
}
