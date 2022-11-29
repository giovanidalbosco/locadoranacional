package br.univille.locadoranacional.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.locadoranacional.entity.Funcionario;
import br.univille.locadoranacional.service.FuncionarioService;


@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService servico;

    @GetMapping
    public ModelAndView index() {
        var listaFuncionarios = servico.getAll();

        return new ModelAndView("funcionario/index", "listaFuncionarios", listaFuncionarios);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var funcionario = new Funcionario();

        return new ModelAndView("funcionario/form", "funcionario", funcionario);
    }

    @PostMapping(params = "form")
    public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("funcionario/form", "funcionario", funcionario);
        }
        
        servico.save(funcionario);

        return new ModelAndView("redirect:/funcionarios");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") long id) {
        var funcionario = servico.getOne(id);

        return new ModelAndView("funcionario/form", "funcionario", funcionario);
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        servico.delete(id);

        return new ModelAndView("redirect:/funcionarios");
    }

}
