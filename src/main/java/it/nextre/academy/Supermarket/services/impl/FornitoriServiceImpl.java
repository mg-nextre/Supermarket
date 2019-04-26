package it.nextre.academy.Supermarket.services.impl;

import it.nextre.academy.Supermarket.model.Fornitori;
import it.nextre.academy.Supermarket.model.Persona;
import it.nextre.academy.Supermarket.repositories.FornitoriRepository;
import it.nextre.academy.Supermarket.services.FornitoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class FornitoriServiceImpl implements FornitoriService {

    private FornitoriRepository fornitoriRepository;

    @Autowired
    public FornitoriServiceImpl(FornitoriRepository fornitoriRepository){
        this.fornitoriRepository = fornitoriRepository;

        /*Fornitori a = new Fornitori("Asdrubale","Pisquano",44, Persona.Sesso.UOMO,"asdrubalepisquano44",new BigDecimal(33000).round(MathContext.DECIMAL32).stripTrailingZeros());
        Fornitori b = new Fornitori("Gargantua","Turiddu",23, Persona.Sesso.UOMO,"gargantuaturiddu23",new BigDecimal(99800).round(MathContext.DECIMAL32).stripTrailingZeros());
        Fornitori c = new Fornitori("Paolo","Culo",53550, Persona.Sesso.ALTRO,"culoculopaoloculoculo",new BigDecimal(-10000000).round(MathContext.DECIMAL32).stripTrailingZeros());
        List<Fornitori> fornitoriList = new ArrayList<>();
        fornitoriList.add(a);
        fornitoriList.add(b);
        fornitoriList.add(c);

        fornitoriRepository.saveAll(fornitoriList);*/
    }

    @Override
    public Fornitori findByPartitaIva(String partitaIva) {
        return fornitoriRepository.findByPartitaIva(partitaIva);
    }

    @Override
    public <S extends Fornitori> S save(S entity) {
        return fornitoriRepository.save(entity);
    }

    @Override
    public <S extends Fornitori> List<S> saveAll(Iterable<S> entities) {
        return fornitoriRepository.saveAll(entities);
    }

    @Override
    public List<Fornitori> findAll() {
        return fornitoriRepository.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        fornitoriRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        fornitoriRepository.deleteAll();
    }
}//end class
