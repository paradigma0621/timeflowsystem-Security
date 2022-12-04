package com.completeTimeFlow.security.server.controller;

import com.completeTimeFlow.security.repository.ClockingRepository;
import com.completeTimeFlow.security.repository.PersonRepository;
import com.completeTimeFlow.security.server.domain.Clocking;
import com.completeTimeFlow.security.server.domain.Person;
import com.completeTimeFlow.security.server.service.ClockingService;
import com.completeTimeFlow.security.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

///@CrossOrigin(origins = "*")
@RestController
public class ClockingController {
    @Autowired
    ClockingRepository clockingRepository;

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

}