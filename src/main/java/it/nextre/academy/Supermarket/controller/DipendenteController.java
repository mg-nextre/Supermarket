package it.nextre.academy.Supermarket.controller;

import it.nextre.academy.Supermarket.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/dipendenti")
public class DipendenteController {

    private DipendenteService dipendenteService;

    @Autowired
    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }

    @GetMapping("/{iban}")
    public String getByCodiceProdotto(@PathVariable @NotNull String iban, Model model){
        model.addAttribute("cliente",dipendenteService.get(iban));
        return "cliente";
    }

    @GetMapping()
    public String get(Model model){
        model.addAttribute("listDipendenti",dipendenteService.getAll());
        return "dipendenti";
    }
}//end class
