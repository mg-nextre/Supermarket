package it.nextre.academy.Supermarket.controller;

import it.nextre.academy.Supermarket.model.Prodotto;
import it.nextre.academy.Supermarket.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/products")
public class ProdottoController {

    private ProdottoService prodottoService;

    @Autowired
    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService = prodottoService;
    }

    /*@GetMapping("products")
    public List<Prodotto> getAllProducts(){

        return prodottoService.getAll();
    }*/

    @GetMapping("/pippo/{nomeProdotto}")
    public String getByNomeProdotto(@PathVariable @NotNull String nomeProdotto, Model model){
        model.addAttribute("listProducts",prodottoService.findByNome(nomeProdotto));
        model.addAttribute("prodotto", new Prodotto());
        return "/products";
    }

    @GetMapping("/{codiceProdotto}")
    public String getByCodiceProdotto(@PathVariable @NotNull String codiceProdotto, Model model){
        model.addAttribute("prodotto",prodottoService.get(codiceProdotto));
        return "/product";
    }

    @GetMapping()
    public String get(Model model){
        model.addAttribute("listProducts",prodottoService.getAll());
        model.addAttribute("prodotto", new Prodotto());
        return "/products";
    }

    @PostMapping()
    public String put(@ModelAttribute Prodotto prodotto, Model model){
        prodottoService.add(prodotto);
        return get(model);
    }

    @DeleteMapping()
    public String deleteByCodiceProdotto(@RequestParam Long id, Model model){
        prodottoService.deleteById(id);
        return get(model);
    }

}//end class
