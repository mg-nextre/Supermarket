package it.nextre.academy.Supermarket.services;

import it.nextre.academy.Supermarket.model.Dipendente;

import java.util.List;

public interface DipendenteService {

    List<Dipendente> getAll();
    Dipendente get(String iban);

}//end interface
