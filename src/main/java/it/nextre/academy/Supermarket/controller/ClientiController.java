package it.nextre.academy.Supermarket.controller;

import it.nextre.academy.Supermarket.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/clienti")
public class ClientiController {

    private ClientiService prodottoService;

    @Autowired
    public ClientiController(ClientiService prodottoService) {
        this.prodottoService = prodottoService;
    }

    @GetMapping("/{codiceCartaPunti}")
    public String getByCodiceProdotto(@PathVariable @NotNull String codiceCartaPunti, Model model){
        model.addAttribute("cliente",prodottoService.get(codiceCartaPunti));
        return "cliente";
    }

    @GetMapping()
    public String get(Model model){
        model.addAttribute("listClienti",prodottoService.getAll());
        return "clienti";
    }
}//end class
