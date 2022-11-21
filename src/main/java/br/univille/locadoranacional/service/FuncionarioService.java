package br.univille.locadoranacional.service;

import java.util.List;

import br.univille.locadoranacional.entity.Funcionario;

public interface FuncionarioService {
    List<Funcionario> getAll();

    Funcionario save(Funcionario funcionario);

    Funcionario getOne(long id);

    void delete(long id);
}
