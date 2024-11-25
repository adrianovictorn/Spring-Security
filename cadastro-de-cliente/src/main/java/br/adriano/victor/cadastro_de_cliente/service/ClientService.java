package br.adriano.victor.cadastro_de_cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.adriano.victor.cadastro_de_cliente.entity.Client;
import br.adriano.victor.cadastro_de_cliente.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    //Cadastrar Cliente
    public Client salvarClient(Client cliente){
        return clientRepository.save(cliente);
    }
    //Listar Clientes
    public List<Client> listaDeClientes(){
        return clientRepository.findAll();
    }
    //Buscar Clientes por ID
    public Client buscarPorId(Long id){
        return clientRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente não encotrado" + id));
    }
    //AtualizarCliente
    public Client atualizarCliente(Long id, Client clienteAtualizado){
        Client clienteExistente = buscarPorId(id);
        clienteExistente.setName(clienteAtualizado.getName());
        clienteExistente.setIdade(clienteAtualizado.getIdade());
        clienteExistente.setSex(clienteAtualizado.getSex());
        return clientRepository.save(clienteExistente);
    }
    //DeletarCliente
    public void deletarCliente(Long id){
        Client clienteExistente = buscarPorId(id);
        clientRepository.delete(clienteExistente);
    }
    
    
}
