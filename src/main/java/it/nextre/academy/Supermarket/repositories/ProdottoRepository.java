package it.nextre.academy.Supermarket.repositories;

import it.nextre.academy.Supermarket.model.Prodotto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProdottoRepository extends CrudRepository<Prodotto, Long> {

    @Override
    List<Prodotto> findAll();

    List<Prodotto> findByNome(String nome);
    Prodotto findByCodiceProdotto(String codiceProdotto);

    @Override
    Prodotto save(Prodotto prodotto);
    @Override
    <S extends Prodotto> List<S> saveAll(Iterable<S> iterable);
    @Override
    Optional<Prodotto> findById(Long aLong);
    @Override
    boolean existsById(Long aLong);
    @Override
    Iterable<Prodotto> findAllById(Iterable<Long> iterable);
    @Override
    long count();
    @Override
    void deleteById(Long aLong);
    @Override
    void delete(Prodotto prodotto);
    @Override
    void deleteAll(Iterable<? extends Prodotto> iterable);
    @Override
    void deleteAll();
}//end interface
