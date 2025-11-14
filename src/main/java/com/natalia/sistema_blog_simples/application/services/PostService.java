package com.natalia.sistema_blog_simples.application.services;

import com.natalia.sistema_blog_simples.application.dto.post.PostRequestDTO;
import com.natalia.sistema_blog_simples.application.dto.post.PostResponseDTO;
import com.natalia.sistema_blog_simples.domain.entities.Post;
import com.natalia.sistema_blog_simples.domain.exceptions.PostNaoEncontradoException;
import com.natalia.sistema_blog_simples.domain.repository.PostRepository;
import com.natalia.sistema_blog_simples.domain.valueobjects.EnumStatusPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostResponseDTO criarPost(PostRequestDTO postRequestDTO) {
        Post post = new Post(postRequestDTO);
        post.setStatus(EnumStatusPost.RASCUNHO);
        post = postRepository.save(post);
        return new PostResponseDTO(post);
    }

    public PostResponseDTO publicarPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new PostNaoEncontradoException("Post não existe."));
        post.setStatus(EnumStatusPost.PUBLICADO);
        post = postRepository.save(post);
        return new PostResponseDTO(post);
    }

    public PostResponseDTO buscarPostId(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new PostNaoEncontradoException("Post não existe."));
        return new PostResponseDTO(post);
    }

    public List<PostResponseDTO> listarPosts() {
        List<Post> posts = postRepository.findAllByStatus(EnumStatusPost.PUBLICADO);
        List<PostResponseDTO> postResponseDTOS = posts.stream().map(post -> new PostResponseDTO(post)).toList();
        return postResponseDTOS;
    }

    public void deletarPost(Long id) {
        postRepository.deleteById(id);
    }
}
