package com.natalia.sistema_blog_simples.application.dto;

import com.natalia.sistema_blog_simples.domain.entities.Usuario;

public record UsuarioResponseDto(
        Long id, String nome, String cpf, String telefone, String email, String status
) {

    public UsuarioResponseDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf().getNumero(), usuario.getTelefone(),
                usuario.getEmail(), usuario.getStatus().toString());
    }
}
