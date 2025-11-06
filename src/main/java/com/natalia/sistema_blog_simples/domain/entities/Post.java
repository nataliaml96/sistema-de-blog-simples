package com.natalia.sistema_blog_simples.domain.entities;

import com.natalia.sistema_blog_simples.application.dto.post.PostRequestDTO;
import com.natalia.sistema_blog_simples.domain.valueobjects.EnumStatusPost;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String conteudo;

    private String autor;

    private EnumStatusPost status;

    public Post(PostRequestDTO postRequestDTO) {
        this.titulo = postRequestDTO.titulo();
        this.conteudo = postRequestDTO.conteudo();
        this.autor = postRequestDTO.autor();

    }
}
