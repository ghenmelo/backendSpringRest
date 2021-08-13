package com.backend.Prova.Nivelamento.controller;

import com.backend.Prova.Nivelamento.model.Person;
import com.backend.Prova.Nivelamento.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * Rota que retorna todas as pessoas
     *
     * @author Guilherme Henrique de Melo
     * @since 12/08/2021
     *
     * @return Todas as pessoas
     */
    @GetMapping
    public Object getPersons() {
        log.info("Buscando todas as pessoas");
        try {
            return personService.getPersons();
        } catch (Exception ex) {
            String message = "Erro ao buscar pessoas";
            log.error(message);
            return message + "Erro : " + ex.getMessage();
        }
    }

    /**
     * Rota que retorna uma pessoa pelo ID
     *
     * @author Guilherme Henrique de Melo
     * @since 12/08/2021
     *
     * @return Pessoa encontrada pelo Id
     */
    @GetMapping("/{id}")
    public Object getPersonById(@PathVariable Long id) {
        log.info("Buscando pessoa por ID ");
        try {
            return personService.getPersonById(id);
        } catch (Exception ex) {
            String message = "Erro ao buscar Pessoa";
            log.error(message);
            return message + "Erro : " +ex.getMessage();
        }
    }

    /**
     * Rota que atualiza uma pessoa
     *
     * @author Guilherme Henrique de Melo
     * @since 12/08/2021
     *
     * @return Pessoa atualizada
     */
    @PutMapping
    public Object updatePerson(@RequestBody Person person) {
        Person id = personService.getPersonById(person.getIdPessoa());
        if (person.getIdentificador().isEmpty() || id == null) {
            return "Está pessoa não possui um identificador ou não existe";
        }

        log.info("Atualizando pessoa {} ", person.getIdentificador());
        try {
            return personService.updatePerson(person);
        } catch (Exception ex) {
            String message = "Erro ao buscar Pessoa";
            log.error(message);
            return message + "Erro : " + ex.getMessage();
        }
    }

    /**
     * Rota que valida uma pessoa
     *
     * @author Guilherme Henrique de Melo
     * @since 12/08/2021
     *
     * @return Mensagem de sucesso ou erro
     */
    @PostMapping
    public Object validatePerson(@RequestBody Person person){
        try {
            return person.validarIdentificadorPessoa();
        } catch (Exception ex) {
            String message = "Erro ao validar pessoa";
            log.error(message);
            return message + "Erro : " + ex.getMessage();
        }
    }

    /**
     * Rota que valida uma pessoa pelo ID dela
     *
     * @author Guilherme Henrique de Melo
     * @since 12/08/2021
     *
     * @return Mensagem de sucesso ou erro
     */
    @GetMapping("/validateById/{id}")
    public Object validatePersonById(@PathVariable Long id){
        try {
            Person person = personService.getPersonById(id);
            return person.validarIdentificadorPessoa();
        } catch (Exception ex) {
            String message = "Erro ao validar pessoa";
            log.error(message);
            return message + "Erro : " +ex.getMessage();
        }
    }

    /**
     * Rota que salva uma nova pessoa
     *
     * @author Guilherme Henrique de Melo
     * @since 12/08/2021
     *
     * @return Pessoa salva
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public Object savePersonById(@RequestBody Person person){
        try {
            return personService.savePerson(person);
        } catch (Exception ex) {
            String message = "Erro ao validar pessoa";
            log.error(message);
            return message + "Erro : " +ex.getMessage();
        }
    }

    /**
     * Rota que deleta uma pessoa pelo ID
     *
     * @author Guilherme Henrique de Melo
     * @since 12/08/2021
     *
     * @return Sucesso em caso de sucesso e Erro em caso de erro
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public Object deletePerson(@PathVariable("id") Long id){
        try {
            personService.deletePerson(id);
            return "Sucesso";
        } catch (Exception ex) {
            String message = "Erro ao validar pessoa";
            log.error(message);
            return message + "Erro : " +ex.getMessage();
        }
    }


}
