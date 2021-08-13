package com.backend.Prova.Nivelamento.service;

import com.backend.Prova.Nivelamento.dao.PersonDao;
import com.backend.Prova.Nivelamento.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public List<Person> getPersons() { return personDao.findAll(); }

    public Person getPersonById(Long id) {
        return personDao.getById(id);
    }

    public Person updatePerson(Person person) {
        return personDao.save(person);
    }

    public Person savePerson(Person person) {
        return personDao.save(person);
    }

    public void deletePerson(Long id) {
        personDao.delete(getPersonById(id));
    }
}
