package it.nextre.academy.Supermarket.repositories;

import it.nextre.academy.Supermarket.model.Dipendente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long> {

    Dipendente findByIban(String iban);
    List<Dipendente> findByRuolo(Dipendente.Ruolo ruolo);

    @Override
    <S extends Dipendente> S save(S entity);

    @Override
    <S extends Dipendente> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Dipendente> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();
}//end interface
