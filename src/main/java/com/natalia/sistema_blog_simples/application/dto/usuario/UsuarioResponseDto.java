package com.natalia.sistema_blog_simples.application.dto.usuario;


import com.natalia.sistema_blog_simples.domain.entities.Usuario;

public record UsuarioResponseDto(Long id, String nome,
                                 String telefone, String email, String status) {


    public UsuarioResponseDto(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getStatus().toString()
        );
    }
}
