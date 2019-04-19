package it.nextre.academy.Supermarket.services.impl;

import it.nextre.academy.Supermarket.model.Dipendente;
import it.nextre.academy.Supermarket.model.Persona;
import it.nextre.academy.Supermarket.services.DipendenteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DipendenteServiceImpl implements DipendenteService {

    private List<Dipendente> dipendenti = new ArrayList<>();

    public DipendenteServiceImpl(){
        Dipendente d1 = new Dipendente("paolo","culo",2, Persona.Sesso.ALTRO, Dipendente.Ruolo.IMPIEGATO,"paoloculoculoculoculoculo");
        Dipendente d2 = new Dipendente("super","paolo",0, Persona.Sesso.ALTRO, Dipendente.Ruolo.IMPIEGATO,"superculo");
        Dipendente d3 = new Dipendente("megaipersuper","paolo",-10000, Persona.Sesso.ALTRO, Dipendente.Ruolo.IMPIEGATO,"megaipersuperculo");
        dipendenti.add(d1);
        dipendenti.add(d2);
        dipendenti.add(d3);
    }

    @Override
    public List<Dipendente> getAll() {
        return this.dipendenti;
    }

    @Override
    public Dipendente get(String iban) {
        return this.dipendenti.stream().filter(d->d.getIban().equals(iban)).findAny().get();
    }
}//end class
