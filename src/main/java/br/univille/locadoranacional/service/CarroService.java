package br.univille.locadoranacional.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.univille.locadoranacional.entity.Carro;

public interface CarroService {
    
    List<Carro> getAll();

    Carro getOne(long id);

    Carro save(Carro carro);

    void delete(long id);

    String salvarFoto(MultipartFile file);
}
