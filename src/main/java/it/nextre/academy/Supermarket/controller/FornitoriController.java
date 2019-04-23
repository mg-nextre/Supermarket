package it.nextre.academy.Supermarket.controller;

import it.nextre.academy.Supermarket.model.Fornitori;
import it.nextre.academy.Supermarket.services.FornitoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("fornitore",fornitoriService.findByPartitaIva(partitaIva));
        return "fornitore";
    }

    @GetMapping()
    public String get(Model model){
        model.addAttribute("listFornitori",fornitoriService.findAll());
        model.addAttribute("fornitore", new Fornitori());

        return "fornitori";
    }

    @PostMapping()
    public String put(@ModelAttribute Fornitori fornitori, Model model){
        fornitoriService.save(fornitori);
        return get(model);
    }

    @DeleteMapping()
    public String deleteByCartaPunti(@RequestParam Long id, Model model){
        fornitoriService.deleteById(id);
        return get(model);
    }
}//end class
