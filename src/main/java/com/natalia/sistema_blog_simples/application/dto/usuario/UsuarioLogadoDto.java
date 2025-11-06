package com.natalia.sistema_blog_simples.application.dto.usuario;

import com.natalia.sistema_blog_simples.domain.entities.Usuario;

public record UsuarioLogadoDto(Long id, String email) {
    public UsuarioLogadoDto(Usuario usuario) {

        this(
                usuario.getId(),
                usuario.getEmail()
        );

    }
}
