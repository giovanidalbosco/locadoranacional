package br.univille.locadoranacional.service.impl;

import java.util.List;

import br.univille.locadoranacional.entity.Aluguel;

public interface AluguelService {

    List<Aluguel> getAll();

    void save(Aluguel aluguel);

    Aluguel findById(long id);

    void delete(long id);

   
}
