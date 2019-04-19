package it.nextre.academy.Supermarket.services.impl;

import it.nextre.academy.Supermarket.model.Clienti;
import it.nextre.academy.Supermarket.model.Persona;
import it.nextre.academy.Supermarket.services.ClientiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientiServiceImpl implements ClientiService {

    private List<Clienti> clienti = new ArrayList<>();


    public ClientiServiceImpl(){
        Clienti a = new Clienti("ciccio","papero",23, Persona.Sesso.UOMO,"cicciopapero23",new BigDecimal(2300).round(MathContext.DECIMAL32).stripTrailingZeros());
        Clienti b = new Clienti("nonna","papera",400, Persona.Sesso.DONNA,"nonnapapera400",new BigDecimal(5000).round(MathContext.DECIMAL32).stripTrailingZeros());
        Clienti c = new Clienti("paperon","de' paperoni",9999, Persona.Sesso.UOMO,"numerouno",new BigDecimal(99999999999L).round(MathContext.DECIMAL32).stripTrailingZeros());
        clienti.add(a);
        clienti.add(b);
        clienti.add(c);
    }

    @Override
    public List<Clienti> getAll() {
        return this.clienti;
    }

    @Override
    public Clienti get(String codiceCartaPunti) {
        return this.clienti.stream().filter(c->c.getCodiceCartaPunti().equals(codiceCartaPunti)).findAny().get();
    }
}//end class
