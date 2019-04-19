package it.nextre.academy.Supermarket.services;

import it.nextre.academy.Supermarket.model.Clienti;

import java.util.List;

public interface ClientiService {

    List<Clienti> getAll();
    Clienti get(String codiceCartaPunti);

}//end interface
