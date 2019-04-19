package it.nextre.academy.Supermarket.services;


import it.nextre.academy.Supermarket.model.Fornitori;

import java.util.List;

public interface FornitoriService {

    List<Fornitori> getAll();
    Fornitori get(String partitaIva);

}//end interface
