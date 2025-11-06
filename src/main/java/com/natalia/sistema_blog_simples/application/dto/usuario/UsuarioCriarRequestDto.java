package com.natalia.sistema_blog_simples.application.dto.usuario;

public record UsuarioCriarRequestDto (String nome, String email, String senha, String cpf, boolean isAdm){
}
