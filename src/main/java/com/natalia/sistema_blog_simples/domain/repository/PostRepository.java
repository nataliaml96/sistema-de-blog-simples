package com.natalia.sistema_blog_simples.domain.repository;

import com.natalia.sistema_blog_simples.domain.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
