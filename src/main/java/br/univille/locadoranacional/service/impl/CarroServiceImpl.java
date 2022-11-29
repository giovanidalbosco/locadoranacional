package br.univille.locadoranacional.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.univille.locadoranacional.entity.Carro;
import br.univille.locadoranacional.repository.CarroRepository;
import br.univille.locadoranacional.service.CarroService;

@Service
public class CarroServiceImpl implements CarroService {
    
    @Autowired
    private CarroRepository repositorio;

    @Override
    public List<Carro> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Carro getOne(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()) {
            return resultado.get();
        }

        return new Carro();
    }

    @Override
    public Carro save(Carro carro) {
        return repositorio.save(carro);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);        
    }

    @Override
    public String salvarFoto(MultipartFile file) {
        // TODO Auto-generated method stub
        return null;
    }


}
