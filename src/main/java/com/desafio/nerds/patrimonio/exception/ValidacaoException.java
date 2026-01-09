package com.desafio.nerds.patrimonio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ValidacaoException {

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<String> regraNegocio(RegraNegocioException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<String> naoEncontrado(NaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}