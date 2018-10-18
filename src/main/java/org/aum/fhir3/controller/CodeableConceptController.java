package org.aum.fhir3.controller;


import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.repository.base.general.CodeableConceptRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/codeableconcept")
public class CodeableConceptController {
    @Autowired
    CodeableConceptRepository codeableConceptRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CodeableConcept codeableConcept){
       return null;
    }
}