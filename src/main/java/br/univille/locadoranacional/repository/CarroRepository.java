package br.univille.locadoranacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.locadoranacional.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{
    
}
