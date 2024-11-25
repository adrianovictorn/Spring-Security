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

import br.adriano.victor.cadastro_de_cliente.entity.Client;
import br.adriano.victor.cadastro_de_cliente.service.ClientService;

@RestController
@RequestMapping("/cliente")
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @PostMapping("/cadastro")
    public ResponseEntity<Client> cadastrarCliente(@RequestBody Client client){
        return ResponseEntity.ok(clientService.salvarClient(client));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Client>> listarCliente(){
        return ResponseEntity.ok(clientService.listaDeClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client>buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clientService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> atualizarCliente(@PathVariable Long id, @RequestBody Client client){
        return ResponseEntity.ok(clientService.atualizarCliente(id, client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarCliente(Long id){
        clientService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
   

}
