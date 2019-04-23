package it.nextre.academy.Supermarket.services;

import it.nextre.academy.Supermarket.model.Prodotto;

import java.util.List;

public interface ProdottoService {

    List<Prodotto> getAll();
    Prodotto get(String codiceProdotto);
    void add(Prodotto prodotto);
    List<Prodotto> findByNome(String nome);

    void deleteById(Long id);
}//end interface
