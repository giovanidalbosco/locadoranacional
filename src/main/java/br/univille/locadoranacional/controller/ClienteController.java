package br.univille.locadoranacional.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.locadoranacional.entity.Cliente;
import br.univille.locadoranacional.service.ClienteService;

@Controller  
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){
        var listaClientes = ((ClienteService) service).getAll();
        return  new ModelAndView("cliente/index","listaClientes",listaClientes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente",cliente);
        return new ModelAndView("cliente/form", dados);
    
   }
   @GetMapping("/alterar/{id}")  
   public ModelAndView alterar(@PathVariable("id") long id){
     var umCliente = service.findById(id);
     HashMap<String,Object> dados = new HashMap<>();
     dados.put("cliente",umCliente);
     return new ModelAndView("cliente/form",dados);
}

public ModelAndView delete(@PathVariable("id") long id){

    service.delete(id);

     return new ModelAndView("redirect:/clientes");

 }

}