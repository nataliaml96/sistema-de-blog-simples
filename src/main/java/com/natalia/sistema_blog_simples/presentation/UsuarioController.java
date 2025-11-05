package com.natalia.sistema_blog_simples.presentation;

import com.natalia.sistema_blog_simples.application.dto.UsuarioCriarRequestDto;
import com.natalia.sistema_blog_simples.application.dto.UsuarioResponseDto;
import com.natalia.sistema_blog_simples.application.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try {

            var usuario = usuarioService.buscarPorId(id);

            if(usuario == null){
                return ResponseEntity.notFound().build();
            }

            return  ResponseEntity.ok(usuario);

        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioCriarRequestDto usuario){

        try {
            var usuarioSalvo = usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(usuarioSalvo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atulizarUsuario(@PathVariable Long id, @RequestBody UsuarioCriarRequestDto usuario){

        try {
            var usuarioSalvo = usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(usuarioSalvo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        return usuarioService.excluirUsuario(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/bloquear")
    public ResponseEntity<?> atualizarBloquear(@PathVariable Long id){

        return usuarioService.bloquearUsuario(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }



    @PatchMapping("/{id}/desbloquear")
    public ResponseEntity<?> atualizarDesbloquear(@PathVariable Long id){

        return usuarioService.desbloquearUsuario(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}