package com.natalia.sistema_blog_simples.application.services;

import com.natalia.sistema_blog_simples.application.dto.post.PostRequestDTO;
import com.natalia.sistema_blog_simples.application.dto.post.PostResponseDTO;
import com.natalia.sistema_blog_simples.domain.entities.Post;
import com.natalia.sistema_blog_simples.domain.repository.PostRepository;
import com.natalia.sistema_blog_simples.domain.valueobjects.EnumStatusPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostResponseDTO criarPost(PostRequestDTO postRequestDTO) {
        Post post = new Post(postRequestDTO);
        post.setStatus(EnumStatusPost.RASCUNHO);
        post = postRepository.save(post);
        PostResponseDTO postResponseDTO = new PostResponseDTO(post);
        return postResponseDTO;
    }
}
