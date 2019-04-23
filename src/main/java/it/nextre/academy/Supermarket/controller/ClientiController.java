package it.nextre.academy.Supermarket.controller;

import it.nextre.academy.Supermarket.model.Clienti;
import it.nextre.academy.Supermarket.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/clienti")
public class ClientiController {

    private ClientiService clientiService;

    @Autowired
    public ClientiController(ClientiService clientiService) {
        this.clientiService = clientiService;
    }

    @GetMapping("/{codiceCartaPunti}")
    public String getByCodiceProdotto(@PathVariable @NotNull String codiceCartaPunti, Model model){
        model.addAttribute("cliente", clientiService.get(codiceCartaPunti));
        return "cliente";
    }

    @GetMapping()
    public String get(Model model){
        model.addAttribute("listClienti", clientiService.getAll());
        model.addAttribute("cliente", new Clienti());

        return "clienti";
    }

    @PostMapping()
    public String put(@ModelAttribute Clienti clienti, Model model){
        clientiService.save(clienti);
        return get(model);
    }

    @DeleteMapping()
    public String deleteByCartaPunti(@RequestParam Long id, Model model){
        clientiService.deleteById(id);
        return get(model);
    }
}//end class
