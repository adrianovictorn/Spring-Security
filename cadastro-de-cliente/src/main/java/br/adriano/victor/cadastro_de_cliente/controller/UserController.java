package br.adriano.victor.cadastro_de_cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.adriano.victor.cadastro_de_cliente.entity.User;
import br.adriano.victor.cadastro_de_cliente.service.UserService;

@RestController
@RequestMapping("/usuario")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("/listar")
    public ResponseEntity<List<User>> listarUsuarios(){
        return ResponseEntity.ok(userService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(userService.buscarUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<User>cadastrarUsuario(@RequestBody User user){
        return ResponseEntity.ok(userService.cadastrarUsuario(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User>atualizarUsuario(@PathVariable Long id, @RequestBody User user){
        return ResponseEntity.ok(userService.atualizarUsuario(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarUsuario(@PathVariable Long id){
        userService.deletarUsuario(id);
        return ResponseEntity.noContent().build();   
    }
}
