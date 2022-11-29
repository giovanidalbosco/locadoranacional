package br.univille.locadoranacional.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.locadoranacional.entity.Aluguel;
import br.univille.locadoranacional.repository.AluguelRepository;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelRepository repositorio;
    @Override
    public List<Aluguel> getAll() {
        
        return repositorio.findAll();
    }
    @Override
    public void save(Aluguel aluguel) {
        repositorio.save(aluguel);
        
    }
    @Override
    public Aluguel findById(long id) {
        var result = repositorio.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Aluguel();
    }
    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
