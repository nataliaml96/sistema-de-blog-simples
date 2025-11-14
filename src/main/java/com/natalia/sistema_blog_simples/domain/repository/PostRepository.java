package com.natalia.sistema_blog_simples.domain.repository;

import com.natalia.sistema_blog_simples.domain.entities.Post;
import com.natalia.sistema_blog_simples.domain.valueobjects.EnumStatusPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    List<Post> findAllByStatus(EnumStatusPost status);
}
