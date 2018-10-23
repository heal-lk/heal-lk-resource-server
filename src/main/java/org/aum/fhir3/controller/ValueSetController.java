package org.aum.fhir3.controller;


import org.aspectj.apache.bcel.classfile.Code;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.repository.base.general.CodeableConceptRepository;
import org.aum.fhir3.repository.base.general.CodingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value = "/valueset")
public class ValueSetController {
    @Autowired
    CodeableConceptRepository codeableConceptRepository;

    @Autowired
    CodingRepository codingRepository;

    @RequestMapping(value = "/list/identifier-type", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> listIdentifierType(){
        CodeableConcept codeableConcept = codeableConceptRepository.findOneCodeableConceptByText("identifier-type");
        return new ResponseEntity<CodeableConcept>(codeableConcept, HttpStatus.OK);
    }
}
