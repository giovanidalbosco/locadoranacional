package br.univille.locadoranacional.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.univille.locadoranacional.entity.Pagamento;
import br.univille.locadoranacional.repository.PagamentoRepository;
import br.univille.locadoranacional.service.PagamentoService;

public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository repositorio;

    @Override
    public List<Pagamento> getAll() {
        return repositorio.findAll();
    }
    
}
