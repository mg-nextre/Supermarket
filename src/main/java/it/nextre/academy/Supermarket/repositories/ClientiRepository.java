package it.nextre.academy.Supermarket.repositories;

import it.nextre.academy.Supermarket.model.Clienti;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientiRepository extends CrudRepository<Clienti,Long> {

    Clienti findByCodiceCartaPunti(String codiceCartaPunti);

    @Override
    <S extends Clienti> S save(S entity);

    @Override
    <S extends Clienti> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Clienti> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();
}//end interface
