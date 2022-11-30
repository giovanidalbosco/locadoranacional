package br.univille.locadoranacional.controller;

import java.security.Provider.Service;

import javax.print.ServiceUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.locadoranacional.entity.Aluguel;
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

   @GetMapping("/novo")
    public ModelAndView novo() {
        var aluguel = new Aluguel();
        return new ModelAndView("aluguel/form", "aluguel", aluguel);
    }

    
    @PostMapping(params = "form")
    public ModelAndView save(Aluguel aluguel, AluguelService service) {
        service.save(aluguel);

        return new ModelAndView("redirect:/aluguel");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") long id) {
        var aluguel = service.getOne(id);
        return new ModelAndView("aluguel/form", "aluguel", aluguel);
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.delete(id);

        return new ModelAndView("redirect:/aluguel");
    }
}