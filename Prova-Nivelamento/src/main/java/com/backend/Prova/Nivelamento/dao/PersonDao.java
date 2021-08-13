package com.backend.Prova.Nivelamento.dao;

import com.backend.Prova.Nivelamento.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

}
