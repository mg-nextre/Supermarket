package it.nextre.academy.Supermarket.services.impl;

import it.nextre.academy.Supermarket.model.Fornitori;
import it.nextre.academy.Supermarket.model.Persona;
import it.nextre.academy.Supermarket.services.FornitoriService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class FornitoriServiceImpl implements FornitoriService {

    List<Fornitori> fornitori = new ArrayList<>();

    public FornitoriServiceImpl(){
        Fornitori a = new Fornitori("Asdrubale","Pisquano",44, Persona.Sesso.UOMO,"asdrubalepisquano44",new BigDecimal(33000).round(MathContext.DECIMAL32).stripTrailingZeros());
        Fornitori b = new Fornitori("Gargantua","Turiddu",23, Persona.Sesso.UOMO,"gargantuaturiddu23",new BigDecimal(99800).round(MathContext.DECIMAL32).stripTrailingZeros());
        Fornitori c = new Fornitori("Paolo","Culo",53550, Persona.Sesso.ALTRO,"culoculopaoloculoculo",new BigDecimal(-10000000).round(MathContext.DECIMAL32).stripTrailingZeros());
        fornitori.add(a);
        fornitori.add(b);
        fornitori.add(c);
    }

    @Override
    public List<Fornitori> getAll() {
        return fornitori;
    }

    @Override
    public Fornitori get(String partitaIva) {
        return fornitori.stream().filter(f->f.getPartitaIva().equals(partitaIva)).findAny().get();
    }
}//end class
