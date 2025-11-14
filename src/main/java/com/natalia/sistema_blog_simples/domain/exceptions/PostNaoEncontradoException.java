package com.natalia.sistema_blog_simples.domain.exceptions;

public class PostNaoEncontradoException extends EntidadeNaoEncontradaException {

    public PostNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public PostNaoEncontradoException(Long id) {
        this(String.format("Não existe um post com este id %d", id));
    }
}
