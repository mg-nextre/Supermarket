package it.nextre.academy.Supermarket.services;

import it.nextre.academy.Supermarket.model.Clienti;

import java.util.List;

public interface ClientiService {

    List<Clienti> getAll();
    Clienti get(String codiceCartaPunti);

    <S extends Clienti> S save(S entity);
    <S extends Clienti> Iterable<S> saveAll(Iterable<S> entities);
    Iterable<Clienti> findAll();
    void deleteById(Long aLong);
    void deleteAll();

}//end interface
