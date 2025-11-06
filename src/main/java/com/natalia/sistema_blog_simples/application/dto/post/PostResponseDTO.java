package com.natalia.sistema_blog_simples.application.dto.post;

import com.natalia.sistema_blog_simples.domain.entities.Post;

public record PostResponseDTO(Long Id, String titulo, String conteudo, String autor) {

    public PostResponseDTO(Post post) {
        this(post.getId(), post.getTitulo(), post.getConteudo(), post.getAutor());
    }
}
