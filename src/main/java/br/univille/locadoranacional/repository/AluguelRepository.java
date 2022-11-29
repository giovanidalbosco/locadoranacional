package br.univille.locadoranacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.locadoranacional.entity.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel,Long> {
    
}
