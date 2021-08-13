package com.backend.Prova.Nivelamento.IdentificadorStrategy;

public class IdentificadorCPF implements ValidateIdenficadorInterface{

    @Override
    public String validaIdentificador(String identificador) {
        String idenficadorValido = "O identificador é inválido";
        if (identificador.length() == 11) {
            idenficadorValido = "O identificador é válido";
        }
        return idenficadorValido;
    }
}
