package br.adriano.victor.cadastro_de_cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.adriano.victor.cadastro_de_cliente.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
    
}
