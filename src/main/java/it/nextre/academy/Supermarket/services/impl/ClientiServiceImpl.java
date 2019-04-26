package it.nextre.academy.Supermarket.services.impl;

import it.nextre.academy.Supermarket.model.Clienti;
import it.nextre.academy.Supermarket.model.Persona;
import it.nextre.academy.Supermarket.repositories.ClientiRepository;
import it.nextre.academy.Supermarket.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientiServiceImpl implements ClientiService {

    private ClientiRepository clientiRepository;

    @Autowired
    public ClientiServiceImpl(ClientiRepository clientiRepository){
        this.clientiRepository = clientiRepository;

        /*Clienti a = new Clienti("ciccio","papero",23, Persona.Sesso.UOMO,"cicciopapero23",new BigDecimal(2300).round(MathContext.DECIMAL32).stripTrailingZeros());
        Clienti b = new Clienti("nonna","papera",400, Persona.Sesso.DONNA,"nonnapapera400",new BigDecimal(5000).round(MathContext.DECIMAL32).stripTrailingZeros());
        Clienti c = new Clienti("paperon","de' paperoni",9999, Persona.Sesso.UOMO,"numerouno",new BigDecimal(99999999999L).round(MathContext.DECIMAL32).stripTrailingZeros());
        List<Clienti> clientiList = new ArrayList<>();
        clientiList.add(a);
        clientiList.add(b);
        clientiList.add(c);
        clientiRepository.saveAll(clientiList);*/
    }

    @Override
    public List<Clienti> getAll() {
        return this.clientiRepository.findAll();
    }

    @Override
    public Clienti get(String codiceCartaPunti) {
        return this.clientiRepository.findByCodiceCartaPunti(codiceCartaPunti);
    }

    @Override
    public <S extends Clienti> S save(S entity) {
        return clientiRepository.save(entity);
    }

    @Override
    public <S extends Clienti> List<S> saveAll(Iterable<S> entities) {
        return clientiRepository.saveAll(entities);
    }

    @Override
    public List<Clienti> findAll() {
        return clientiRepository.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        clientiRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        clientiRepository.deleteAll();
    }
}//end class
