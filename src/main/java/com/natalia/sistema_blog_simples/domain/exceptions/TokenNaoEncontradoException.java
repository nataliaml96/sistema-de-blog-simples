package com.natalia.sistema_blog_simples.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TokenNaoEncontradoException extends EntidadeNaoEncontradaException {

    public TokenNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public TokenNaoEncontradoException(Long id) {
        this(String.format("Não existe um cadastro de cidade com código %d", id));
    }
}