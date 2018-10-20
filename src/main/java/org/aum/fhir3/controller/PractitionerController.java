package org.aum.fhir3.controller;


import org.aum.fhir3.model.base.general.Address;
import org.aum.fhir3.model.base.general.Attachment;
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

import org.aum.fhir3.repository.base.individual.PractitionerRepository;
import org.aum.fhir3.model.base.individual.Practitioner;
import org.aum.system.Logger;
import org.aum.fhir3.outcome.OperationOutcome;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/practitioner")
public class PractitionerController {
    @Autowired
    PractitionerRepository practitionerRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Practitioner practitioner){
        /*try {
            Practitioner tmp = practitionerRepository.findPractitionerById(practitioner.getId());
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
        }*/
        return null;
    }


    @RequestMapping(value = "/read/{nic}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> read(@PathVariable String id){
        /*List<Practitioner> tmp = practitionerRepository.findAll();
        if(tmp != null){
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        }
        return new ResponseEntity<>(OperationOutcome.RecordNotFound(), HttpStatus.OK);*/
        return null;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?>  list(){
        /*return new ResponseEntity<List>(practitionerRepository.findAll(), HttpStatus.OK);*/
        return null;
    }


    @RequestMapping(value="/sample/{parameter}", method = RequestMethod.GET,  produces = "application/json")
    public ResponseEntity<?> sample(@PathVariable String parameter){
        /*Practitioner practitioner = new Practitioner();
        practitioner.setFirstName("John");
        practitioner.setLastName("Doe");
        //practitioner.setNic("999999999");
        practitioner.setActive(true);
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
        practitioner.setTelecom(ls);
        practitioner.setGender("male");
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
        practitioner.setAddress(addressList);
        Attachment photo = new Attachment();
        photo.setUrl("http://github.com");
        photo.setTitle("My Photo");
        photo.setContentType("image");
        photo.setCreated(new Date());
        photo.setData("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaa");
        practitioner.setPhoto(photo);

        return new ResponseEntity<>(practitioner, HttpStatus.OK);*/
        return null;
    }
    
}
