package br.univille.locadoranacional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.locadoranacional.service.impl.AluguelService;

@Controller
@RequestMapping("/aluguel")
public class AluguelController {
    @Autowired
    private AluguelService service;

    @Autowired
    private AluguelService aluguelService;

    @GetMapping
    public ModelAndView index(){
        var listaAluguel = service.getAll();
        return new ModelAndView("aluguel/index", "listaAluguel",listaAluguel);

    
   }
}