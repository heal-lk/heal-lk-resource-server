package org.aum;

import java.util.Arrays;

import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Coding;
import org.aum.fhir3.repository.base.general.CodeableConceptRepository;
import org.aum.fhir3.repository.base.general.CodingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import org.aum.fhir3.repository.base.general.ContactPointRepository;
import org.aum.fhir3.repository.base.individual.PersonRepository;

@Component
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactPointRepository contactPointRepository;

    @Autowired
    private CodingRepository codingRepository;

    @Autowired
    private CodeableConceptRepository codeableConceptRepository;
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Adding constant fields in to database");
        List<Coding> codingList = new ArrayList<Coding>();
        Coding coding1 = new Coding("http://hl7.org/fhir/v2/0203", "1.0",
                "DL", "Driverse License Number", true);
        //coding1 = codingRepository.saveAndFlush(coding1);
        codingList.add(coding1);
        Coding coding2 = new Coding("http://hl7.org/fhir/v2/0203", "1.0",
                "NIC", "National Identity Card Number", true);
        //coding2 = codingRepository.saveAndFlush(coding2);
        codingList.add(coding2);
        CodeableConcept codeableConcept = new CodeableConcept();
        codeableConcept.setText("identifier-type");
        codeableConcept = codeableConceptRepository.save(codeableConcept);
        codeableConcept.setCoding(codingList);
        codeableConcept = codeableConceptRepository.save(codeableConcept);
    }

}
