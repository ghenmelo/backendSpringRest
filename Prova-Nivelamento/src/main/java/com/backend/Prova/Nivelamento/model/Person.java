package com.backend.Prova.Nivelamento.model;

import com.backend.Prova.Nivelamento.IdentificadorStrategy.IdentificadorCNPJ;
import com.backend.Prova.Nivelamento.IdentificadorStrategy.IdentificadorCPF;
import com.backend.Prova.Nivelamento.domain.ValidateIdentificador;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "Pessoas")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPESSOA")
    private Long idPessoa;

    @Column(name = "IDENTIFICADOR")
    private String identificador;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPOIDENTIFICADOR")
    private String tipoIdentificador;

    /**
     * Metodo que valida o identificador da pessoa
     *
     * @author Guilherme Henrique de Melo
     * @since 12/08/2021
     *
     * @return Mensagem de retorno sobre o identificador
     */
    public String validarIdentificadorPessoa() {
        String isValido = "Essa pessoa não possui um tipo de identificador valido";

        if (identificador == null || identificador.length() == 0) {
            return "O Identificador não possui valor";
        }

        if (this.tipoIdentificador.equals("CNPJ")) {
            isValido = ValidateIdentificador.validarIdentificadorPessoa(new IdentificadorCNPJ(), this.identificador);
        } else if (this.tipoIdentificador.equals("CPF")) {
            isValido  =ValidateIdentificador.validarIdentificadorPessoa(new IdentificadorCPF(), this.identificador);
        }
        return isValido;
    }
}
