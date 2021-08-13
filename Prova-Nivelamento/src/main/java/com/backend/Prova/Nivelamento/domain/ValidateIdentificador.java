package com.backend.Prova.Nivelamento.domain;

import com.backend.Prova.Nivelamento.IdentificadorStrategy.ValidateIdenficadorInterface;

public class ValidateIdentificador {

    public static String validarIdentificadorPessoa(ValidateIdenficadorInterface validateIdenficadorInterface, String identificador) {
        return validateIdenficadorInterface.validaIdentificador(identificador);
    }
}
