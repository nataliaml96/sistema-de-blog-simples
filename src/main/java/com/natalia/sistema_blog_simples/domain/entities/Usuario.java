package com.natalia.sistema_blog_simples.domain.entities;


import com.natalia.sistema_blog_simples.application.dto.UsuarioCriarRequestDto;
import com.natalia.sistema_blog_simples.domain.valueobjects.CPF;
import com.natalia.sistema_blog_simples.domain.valueobjects.EnumStatusUsuario;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Data
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor

public abstract class Usuario {
    //Deve haver uma classe Usuario com, no mínimo, os campos:
    // id, nome, email (login) e senha.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String senha;
    @Embedded
    private CPF cpf;
    private String email;
    private String telefone;
    private EnumStatusUsuario status = EnumStatusUsuario.ATIVO;
    @OneToMany
    @JoinColumn(name = "usuario_id", nullable = true)
    private List<Menu> menuAcesso;

    public Usuario(Long id, String nome, String senha, CPF cpf, String email, String telefone, EnumStatusUsuario status, List<Menu> menuAcesso) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.menuAcesso = menuAcesso;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnumStatusUsuario getStatus() {
        return status;
    }

    public void setStatus(EnumStatusUsuario status) {
        this.status = status;
    }

    public List<Menu> getMenuAcesso() {
        return menuAcesso;
    }

    public void setMenuAcesso(List<Menu> menuAcesso) {
        this.menuAcesso = menuAcesso;
    }

    public Usuario (UsuarioCriarRequestDto usuario){
        this.email = usuario.email();
        this.senha = usuario.senha();
        this.cpf = new CPF(usuario.cpf());
        this.nome = usuario.nome();
    }

    public Usuario atulizarUsuarioFromDTO(Usuario usuarioBanco, UsuarioCriarRequestDto dto){
        usuarioBanco.setCpf(new CPF(dto.cpf()));
        usuarioBanco.setEmail(dto.email());
        usuarioBanco.setNome(dto.nome());
        usuarioBanco.setSenha(dto.senha());
        return usuarioBanco;
    }
}
