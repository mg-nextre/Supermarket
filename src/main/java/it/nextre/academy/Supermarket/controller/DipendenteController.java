package it.nextre.academy.Supermarket.controller;

import it.nextre.academy.Supermarket.model.Dipendente;
import it.nextre.academy.Supermarket.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("cliente",dipendenteService.findByIban(iban));
        return "cliente";
    }

    @GetMapping()
    public String get(Model model){
        model.addAttribute("listDipendenti",dipendenteService.findAll());
        model.addAttribute("dipendente", new Dipendente());

        return "dipendenti";
    }

    @PostMapping()
    public String put(@ModelAttribute Dipendente dipendente, Model model){
        dipendenteService.save(dipendente);
        return get(model);
    }

    @DeleteMapping()
    public String deleteById(@RequestParam Long id, Model model){
        dipendenteService.deleteById(id);
        return get(model);
    }
}//end class
