package com.natalia.sistema_blog_simples.application.dto.post;

import jakarta.validation.constraints.NotBlank;

public record PostRequestDTO(@NotBlank(message = "Campo Título não pode ser vazio.") String titulo,
                             @NotBlank(message = "Campo Conteúdo não pode ser vazio.") String conteudo,
                             @NotBlank(message = "Campo Autor não pode ser vazio.") String autor) {

}
