package it.nextre.academy.Supermarket.services.impl;

import it.nextre.academy.Supermarket.model.Dipendente;
import it.nextre.academy.Supermarket.model.Persona;
import it.nextre.academy.Supermarket.repositories.DipendenteRepository;
import it.nextre.academy.Supermarket.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DipendenteServiceImpl implements DipendenteService {

    private DipendenteRepository dipendenteRepository;

    @Autowired
    public DipendenteServiceImpl(DipendenteRepository dipendenteRepository){
        this.dipendenteRepository = dipendenteRepository;

        /*Dipendente d1 = new Dipendente("paolo","culo",2, Persona.Sesso.ALTRO, Dipendente.Ruolo.IMPIEGATO,"paoloculoculoculoculoculo");
        Dipendente d2 = new Dipendente("super","paolo",0, Persona.Sesso.ALTRO, Dipendente.Ruolo.IMPIEGATO,"superculo");
        Dipendente d3 = new Dipendente("megaipersuper","paolo",-10000, Persona.Sesso.ALTRO, Dipendente.Ruolo.IMPIEGATO,"megaipersuperculo");
        List<Dipendente> dipendenteList = new ArrayList<>();
        dipendenteList.add(d1);
        dipendenteList.add(d2);
        dipendenteList.add(d3);

        dipendenteRepository.saveAll(dipendenteList);*/
    }

    @Override
    public Dipendente findByIban(String iban) {
        return dipendenteRepository.findByIban(iban);
    }

    @Override
    public List<Dipendente> findByRuolo(Dipendente.Ruolo ruolo) {
        return dipendenteRepository.findByRuolo(ruolo);
    }

    @Override
    public <S extends Dipendente> S save(S entity) {
        return dipendenteRepository.save(entity);
    }

    @Override
    public <S extends Dipendente> List<S> saveAll(Iterable<S> entities) {
        return dipendenteRepository.saveAll(entities);
    }

    @Override
    public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        dipendenteRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        dipendenteRepository.deleteAll();
    }
}//end class
