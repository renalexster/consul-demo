package com.grupocard.consul.demo.service;

import com.grupocard.consul.demo.model.Person;
import com.grupocard.consul.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl {

    private final PersonRepository repository;


    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Person saveAndFlush(Person person){
        return repository.saveAndFlush(person);
    }

    public List<Person> listAll(){
        return repository.findAll();
    }
}
