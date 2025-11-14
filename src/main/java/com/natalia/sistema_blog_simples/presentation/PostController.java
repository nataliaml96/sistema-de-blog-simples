package com.natalia.sistema_blog_simples.presentation;

import com.natalia.sistema_blog_simples.application.dto.post.PostRequestDTO;
import com.natalia.sistema_blog_simples.application.dto.post.PostResponseDTO;
import com.natalia.sistema_blog_simples.application.services.PostService;
import com.natalia.sistema_blog_simples.domain.entities.Post;
import com.natalia.sistema_blog_simples.domain.valueobjects.EnumStatusPost;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> publicarPost(@PathVariable Long id) {
        PostResponseDTO postResponseDTO = postService.publicarPost(id);
        return ResponseEntity.ok(postResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> buscarPostId(@PathVariable Long id) {
        PostResponseDTO postResponseDTO = postService.buscarPostId(id);
        return ResponseEntity.ok(postResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> listarPosts() {
        List<PostResponseDTO> postResponseDTOS = postService.listarPosts();
        return ResponseEntity.ok(postResponseDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPost(@PathVariable Long id) {
        postService.deletarPost(id);
        return ResponseEntity.noContent().build();
    }
}
