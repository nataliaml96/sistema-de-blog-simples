package com.natalia.sistema_blog_simples.domain.repository;

import com.natalia.sistema_blog_simples.domain.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {

    Optional<Token> findByToken(String token);
}
