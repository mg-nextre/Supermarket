package it.nextre.academy.Supermarket.repositories;

import it.nextre.academy.Supermarket.model.Fornitori;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FornitoriRepository extends CrudRepository<Fornitori,Long> {

    Fornitori findByPartitaIva(String partitaIva);

    @Override
    <S extends Fornitori> S save(S entity);

    @Override
    <S extends Fornitori> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Fornitori> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();
}//end interface
