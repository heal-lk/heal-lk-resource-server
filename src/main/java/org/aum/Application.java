package org.aum;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Calendar;

import org.aum.fhir3.repository.general.ContactPointRepository;
import org.aum.fhir3.repository.individual.PersonRepository;
import org.aum.fhir3.model.general.Coding;

@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactPointRepository contactPointRepository;
    
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
    }

}
