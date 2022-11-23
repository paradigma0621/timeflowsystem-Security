package com.completeTimeFlow.core.server.controller;

import com.completeTimeFlow.core.repository.PersonRepository;
import com.completeTimeFlow.core.server.domain.Clocking;
import com.completeTimeFlow.core.server.domain.Person;
import com.completeTimeFlow.core.repository.ClockingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ClockingController {
    @Autowired
    ClockingRepository clockingRepository;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/testCreateTablesAndSave")
    @GetMapping
    public ResponseEntity<String> creating() {
        Person person = new Person();

        person.setName("João Pedro");
        person.setRegisterDate(new Date());
        personRepository.save(person);

        Clocking clocking = new Clocking();
        clocking.setGrade(1.3);
        clocking.setClockingDate(new Date());
        clocking.setPerson(person);
        clocking.setSubject("Programação");

        clockingRepository.save(clocking);
        return new ResponseEntity<String>("Saved!!!", HttpStatus.OK);
    }
}