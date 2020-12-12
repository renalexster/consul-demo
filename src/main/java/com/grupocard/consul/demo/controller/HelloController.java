package com.grupocard.consul.demo.controller;

import com.grupocard.consul.demo.model.Person;
import com.grupocard.consul.demo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class HelloController {
    @Value("${app.greeting}")
    private String greeting;

    private final PersonServiceImpl personService;

    public HelloController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok(greeting);
    }

    @GetMapping
    public ResponseEntity<List<Person>> listAllPerson() {
        return ResponseEntity.ok(personService.listAll());
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.saveAndFlush(person));
    }
}
