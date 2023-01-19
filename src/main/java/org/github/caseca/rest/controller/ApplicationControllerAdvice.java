package org.github.caseca.rest.controller;

import org.github.caseca.exception.MovieNotFoundException;
import org.github.caseca.exception.RegraDeNegocioExecption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleMovieNotFoundException(MovieNotFoundException ex){
        String mensagemErro = ex.getMessage();
        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(RegraDeNegocioExecption.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraDeNegocioExecption ex){
        String mensagemErro = ex.getMessage();
        return new ApiErrors(mensagemErro);
    }
}
