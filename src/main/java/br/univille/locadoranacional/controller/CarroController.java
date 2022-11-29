package br.univille.locadoranacional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.locadoranacional.entity.Carro;
import br.univille.locadoranacional.service.CarroService;


@Controller
@RequestMapping("/carros")
public class CarroController {
    
    @Autowired
    private CarroService servico;

    @GetMapping
    public ModelAndView index() {
        var listaCarros = servico.getAll();

        return new ModelAndView("carro/index", "listaCarros", listaCarros);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var carro = new Carro();

        return new ModelAndView("carro/form", "carro", carro);
    }

    @PostMapping(params = "form")
    public ModelAndView salvar(Carro carro) {
        servico.save(carro);

        return new ModelAndView("redirect:/carros");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") long id) {
        var carro = servico.getOne(id);
        return new ModelAndView("carro/form", "carro", carro);
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        servico.delete(id);

        return new ModelAndView("redirect:/carros");
    }
    
}
