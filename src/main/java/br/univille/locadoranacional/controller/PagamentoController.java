package br.univille.locadoranacional.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.locadoranacional.entity.Pagamento;
import br.univille.locadoranacional.service.PagamentoService;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService servico;

    @GetMapping
    public ModelAndView index() {
        var listaPagamentos = servico.getAll();

        return new ModelAndView("pagamento/index", "listaPagamentos", listaPagamentos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var pagamento = new Pagamento();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("pagamento", pagamento);
        return new ModelAndView("pagamento/form", dados);
    }
}
