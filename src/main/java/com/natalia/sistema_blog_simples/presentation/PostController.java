package com.natalia.sistema_blog_simples.presentation;

import com.natalia.sistema_blog_simples.application.dto.post.PostRequestDTO;
import com.natalia.sistema_blog_simples.application.dto.post.PostResponseDTO;
import com.natalia.sistema_blog_simples.application.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDTO> criarPost(@RequestBody @Valid PostRequestDTO postRequestDTO) {
        PostResponseDTO postResponseDTO = postService.criarPost(postRequestDTO);
        return ResponseEntity.ok(postResponseDTO);
    }
}
