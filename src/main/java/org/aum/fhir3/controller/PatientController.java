package org.aum.fhir3.controller;

import org.aum.fhir3.model.base.general.Address;
import org.aum.fhir3.model.base.general.Attachment;
import org.aum.fhir3.model.base.general.ContactPoint;
import org.aum.fhir3.model.base.general.Period;
import org.aum.fhir3.model.base.individual.PatientContact;
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

    @RequestMapping(value="/sample/{parameter}", method = RequestMethod.GET,  produces = "application/json")
    public ResponseEntity<?> sample(@PathVariable String parameter){
        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setNic("999999999");
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
        patient.setMarried(false);
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

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
    
}
