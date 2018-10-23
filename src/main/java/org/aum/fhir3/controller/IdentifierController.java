package org.aum.fhir3.controller;

import org.aum.fhir3.model.base.general.*;
import org.aum.fhir3.model.base.individual.PatientContact;
import org.aum.fhir3.repository.base.general.CodeableConceptRepository;
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

    @Autowired
    private CodeableConceptRepository codeableConceptRepository;

    @RequestMapping(value="/sample/{parameter}", method = RequestMethod.GET,  produces = "application/json")
    public ResponseEntity<?> sample(@PathVariable String parameter){
        Identifier tmp = new Identifier();
        tmp.setUse("official");
        tmp.setType(codeableConceptRepository.findOneCodeableConceptByText("identifier-type"));
        tmp.setValue("999999999");
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

}
