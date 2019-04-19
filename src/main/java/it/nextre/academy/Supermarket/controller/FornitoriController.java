package it.nextre.academy.Supermarket.controller;

import it.nextre.academy.Supermarket.services.FornitoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/fornitori")
public class FornitoriController {

    private FornitoriService fornitoriService;

    @Autowired
    public FornitoriController(FornitoriService fornitoriService) {
        this.fornitoriService = fornitoriService;
    }

    @GetMapping("/{partitaIva}")
    public String getByCodiceProdotto(@PathVariable @NotNull String partitaIva, Model model){
        model.addAttribute("fornitore",fornitoriService.get(partitaIva));
        return "fornitore";
    }

    @GetMapping()
    public String get(Model model){
        model.addAttribute("listFornitori",fornitoriService.getAll());
        return "fornitori";
    }
}//end class
