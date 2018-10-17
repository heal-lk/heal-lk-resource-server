package org.aum;

import org.aum.fhir3.repository.general.ContactPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.aum.fhir3.model.individual.Person;
import org.aum.fhir3.model.general.ContactPoint;
import org.aum.fhir3.repository.individual.PersonRepository;
import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class TestController {
    @Autowired
    private ContactPointRepository contactPointRepository;
    @Autowired
    private PersonRepository personRepository;


    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ContactPoint c = new ContactPoint();
        Person n = new Person();
        //n.setName(name);
        //n.setEmail(email);
        //n.setTelecom(c);
        personRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<Person> getAllUsers() {
        // This returns a JSON or XML with the users
        return personRepository.findAll();
        //return "hello";
    }


}
