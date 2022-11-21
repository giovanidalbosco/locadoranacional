package br.univille.locadoranacional.service;

import java.util.List;

import br.univille.locadoranacional.entity.Cliente;


public interface ClienteService {

    List<Cliente> getAll();
    Cliente save(Cliente cliente);
    Cliente findById(long id);
    void delete(long id);
    List<Cliente> findByNome(String nome);

    
    
}
