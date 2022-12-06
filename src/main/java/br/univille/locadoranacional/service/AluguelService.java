package br.univille.locadoranacional.service;

import java.util.List;

import br.univille.locadoranacional.entity.Aluguel;

public interface AluguelService {
    List<Aluguel> getAll();

    Aluguel getOne(long id);

    Aluguel save(Aluguel aluguel);

    void delete(long id);
   
}
