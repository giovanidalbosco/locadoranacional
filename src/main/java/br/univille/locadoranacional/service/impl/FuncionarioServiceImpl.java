package br.univille.locadoranacional.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import br.univille.locadoranacional.entity.Funcionario;
import br.univille.locadoranacional.repository.FuncionarioRepository;
import br.univille.locadoranacional.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repositorio;

    @Override
    public List<Funcionario> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repositorio.save(funcionario);
    }

    @Override
    public Funcionario getOne(long id) {
        var busca = repositorio.findById(id);
        if(busca.isPresent()) {
            return busca.get();
        }

        return new Funcionario();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);        
    }


}
