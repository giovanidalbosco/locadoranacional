package br.univille.locadoranacional.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.locadoranacional.entity.Aluguel;
import br.univille.locadoranacional.repository.AluguelRepository;
import br.univille.locadoranacional.service.AluguelService;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelRepository repositorio;

    @Override
    public List<Aluguel> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Aluguel save(Aluguel aluguel) {
        return repositorio.save(aluguel);
    }

    @Override
    public Aluguel getOne(long id) {
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
