package org.aum.fhir3.controller;

import org.aum.fhir3.model.base.general.Address;
import org.aum.fhir3.model.base.general.Attachment;
import org.aum.fhir3.model.base.general.ContactPoint;
import org.aum.fhir3.model.base.general.Period;
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


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

class TestReturn{
    private String coding;
    private String value;

    TestReturn(String coding, String value){
        this.coding = coding;
        this.value = value;
    }

    public String getCoding() {
        return coding;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }
}

@RestController
@RequestMapping(value = "/identifer")
public class IdentifierController {
    @Autowired
    private IdentifierRepository identifierRepository;

    @RequestMapping(value = "/find/{coding}/{value}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?>  find(@PathVariable String coding, @PathVariable String value){
        //return new ResponseEntity<List>(patientRepository.findAll(), HttpStatus.OK);
        return new ResponseEntity<>(new TestReturn(coding,value), HttpStatus.OK);
    }

}
