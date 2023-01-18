package org.github.caseca.rest.controller;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    @Getter
    private List<String> errors;

    public ApiErrors(String mensagemErrors){
        this.errors = Arrays.asList(mensagemErrors);
    }
}
