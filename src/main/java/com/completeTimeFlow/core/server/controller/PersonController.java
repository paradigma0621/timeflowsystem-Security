package com.completeTimeFlow.core.server.controller;

import com.completeTimeFlow.core.repository.ClockingRepository;
import com.completeTimeFlow.core.repository.PersonRepository;
import com.completeTimeFlow.core.server.domain.Clocking;
import com.completeTimeFlow.core.server.domain.Person;
import com.completeTimeFlow.core.server.service.ClockingService;
import com.completeTimeFlow.core.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ClockingService clockingService;

    @RequestMapping("/testCreateTablesAndSave")
    @GetMapping
    public ResponseEntity<String> creating() {
        Person person = new Person();

        person.setName("Salomão");
        person.setRegisterDate(TimeUtil.getConvertedDate(new Date()));
        personRepository.save(person);

        Clocking clocking = new Clocking();
        clocking.setGrade(9.9);
        clocking.setClockingStartDate(new Date());
        clocking.setPerson(person);
        clocking.setSubject("Programação deep");
        clockingService.saveDateFormatted(clocking);
        return new ResponseEntity<String>("Saved again!!!", HttpStatus.OK);
    }

    @RequestMapping("/sayHello")
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<String>("Hello!!!", HttpStatus.OK);
    }

    @RequestMapping("/getPerson")
    @GetMapping
    public ResponseEntity<Person> getPerson() {
        Person person = new Person();
        person.setId(126L);
        person.setName("Joaquim da Bahia");
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping("/create")
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
