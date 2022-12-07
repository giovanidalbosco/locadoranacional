package br.univille.locadoranacional.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.locadoranacional.entity.Aluguel;
import br.univille.locadoranacional.service.AluguelService;
import br.univille.locadoranacional.service.CarroService;
import br.univille.locadoranacional.service.ClienteService;
import br.univille.locadoranacional.service.FuncionarioService;

@Controller
@RequestMapping("/aluguel")
public class AluguelController {
   
    @Autowired
    private ClienteService servicoCliente;

    @Autowired
    private FuncionarioService servicoFuncionario;

    @Autowired
    private CarroService servicoCarro;

    @Autowired
    private AluguelService service;

    @GetMapping
    public ModelAndView index(){
        var listaAluguel = service.getAll();
        return new ModelAndView("aluguel/index", "listaAluguel",listaAluguel);
    
   }

    @GetMapping("/novo/{id}")
    public ModelAndView novo(@PathVariable("id") long id) {
        var carro = servicoCarro.getOne(id);
        var aluguel = new Aluguel();
        var listaClientes = servicoCliente.getAll();
        var listaFuncionarios = servicoFuncionario.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("carroEscolhido", carro);
        dados.put("aluguel", aluguel);
        dados.put("listaClientes", listaClientes);
        dados.put("listaFuncionarios", listaFuncionarios);
        return new ModelAndView("aluguel/form", dados);
    }

    
    @PostMapping(params = "form")
    public ModelAndView save(Aluguel aluguel) {
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