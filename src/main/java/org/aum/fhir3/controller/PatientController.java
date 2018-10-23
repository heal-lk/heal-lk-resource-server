package org.aum.fhir3.controller;

import org.aum.fhir3.model.base.general.*;
import org.aum.fhir3.model.base.individual.PatientContact;
import org.aum.fhir3.repository.base.general.IdentifierRepository;
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
import org.aum.fhir3.model.base.individual.Patient;
import org.aum.fhir3.repository.base.individual.PatientRepository;
import org.aum.fhir3.repository.base.general.TestRepository;
import org.aum.fhir3.outcome.OperationOutcome;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.lang.Long;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private IdentifierRepository identifierRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Patient patient){
        Identifier identifier = patient.getIdentifier();

        if( (identifier.getType() == null) || (identifier.getValue() == null) ){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InvalidParameter(),
                                                                                HttpStatus.OK);
        }
        identifier = identifierRepository.findIdentifierByValue(identifier.getValue());
        if(identifier != null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordExists(),
                    HttpStatus.OK);
        }

        try{
            Patient tmpPatient = new Patient();
            tmpPatient = patientRepository.save(tmpPatient);
            patient.setId(tmpPatient.getId());
            patient = patientRepository.save(patient);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        }catch(Exception e){
            Logger.LogError("Record already exists");
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/readByValue/{value}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> readByValue(String value){
        Identifier identifier;
        identifier = identifierRepository.findIdentifierByValue(value);
        if(identifier == null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(),
                    HttpStatus.OK);
        }

        Patient patient = patientRepository.findPatientByIdentifier(identifier);

        if(patient == null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> read(String id){
        try {
            Patient patient = patientRepository.findPatientById(Long.parseLong(id));
            if(patient == null){
                return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(),
                        HttpStatus.OK);
            }else {
                return new ResponseEntity<Patient>(patient, HttpStatus.OK);
            }
        }catch(Exception e){
            Logger.LogError("log parse error");
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(){
        return "updating a patient object";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(){
        return "deleting a patient object";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?>  list(){
        return new ResponseEntity<List>(patientRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/sample/{parameter}", method = RequestMethod.GET,  produces = "application/json")
    public ResponseEntity<?> sample(@PathVariable String parameter){
        Patient patient = new Patient();
        patient.setMaritialStatus(false);
        HumanName name = new HumanName();
        name.setFamily("Doe");
        name.setGiven("John");
        patient.setName(name);
        return new ResponseEntity<>(patient, HttpStatus.OK);
        /*Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setActive(true);
        ContactPoint contactPoint = new ContactPoint();
        contactPoint.setSystem("phone");
        contactPoint.setValue("0094779867098");
        contactPoint.setUse("home");
        contactPoint.setRank("1");
        Period period = new Period();
        period.setStart(new Date());
        period.setEnd(new Date());
        contactPoint.setPeriod(period);
        List<ContactPoint> ls = new ArrayList<ContactPoint>();
        ls.add(contactPoint);
        patient.setTelecom(ls);
        patient.setGender("male");
        patient.setDeceased(true);
        patient.setDeceasedDateTime(new Date());
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
        address.setPeriod(period);
        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address);
        patient.setAddress(addressList);
        patient.setMaritialStatus(false);
        Attachment photo = new Attachment();
        photo.setUrl("http://github.com");
        photo.setTitle("My Photo");
        photo.setContentType("image");
        photo.setCreated(new Date());
        photo.setData("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaa");
        patient.setPhoto(photo);
        PatientContact patientContact = new PatientContact();
        patientContact.setFirstname("Mary");
        patientContact.setLastname("Jane");
        patientContact.setTelecom(contactPoint);
        patientContact.setAddress(address);
        patientContact.setGender("female");
        patientContact.setPeriod(period);
        patientContact.setOrganization(null);
        patient.setContact(patientContact);

        return new ResponseEntity<>(patient, HttpStatus.OK);*/
    }
    
}
