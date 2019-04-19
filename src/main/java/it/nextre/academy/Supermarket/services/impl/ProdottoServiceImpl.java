package it.nextre.academy.Supermarket.services.impl;

import it.nextre.academy.Supermarket.model.Prodotto;
import it.nextre.academy.Supermarket.repositories.ProdottoRepository;
import it.nextre.academy.Supermarket.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdottoServiceImpl implements ProdottoService {

    private ProdottoRepository prodottoRepository;

    @Autowired
    public ProdottoServiceImpl(ProdottoRepository prodottoRepository){
        this.prodottoRepository = prodottoRepository;

        List<Prodotto> prodotti = new ArrayList<>();

        Prodotto a = new Prodotto("sardine",new BigDecimal(12.03).round(MathContext.DECIMAL32).stripTrailingZeros(),"sard12345");
        Prodotto b = new Prodotto("sassi",new BigDecimal(0.75).round(MathContext.DECIMAL32).stripTrailingZeros(),"sasso987");
        Prodotto c = new Prodotto("carta sxc",new BigDecimal(55.55).round(MathContext.DECIMAL32).stripTrailingZeros(),"sxc-card");
        Prodotto d = new Prodotto("carta sxc",new BigDecimal(55.55).round(MathContext.DECIMAL32).stripTrailingZeros(),"sxc");
        Prodotto e = new Prodotto("carta sxc",new BigDecimal(55.55).round(MathContext.DECIMAL32).stripTrailingZeros(),"card-iscriviti");
        Prodotto f = new Prodotto("carta sxc",new BigDecimal(55.55).round(MathContext.DECIMAL32).stripTrailingZeros(),"iscriviti");
        Prodotto g = new Prodotto("carta sxc",new BigDecimal(55.55).round(MathContext.DECIMAL32).stripTrailingZeros(),"card");
        prodotti.add(a);
        prodotti.add(b);
        prodotti.add(c);
        prodotti.add(d);
        prodotti.add(e);
        prodotti.add(f);
        prodotti.add(g);
        prodottoRepository.saveAll(prodotti);
    }

    @Override
    public List<Prodotto> getAll() {
        return this.prodottoRepository.findAll();
    }

    @Override
    public Prodotto get(String codiceProdotto) {
        return this.prodottoRepository.findByCodiceProdotto(codiceProdotto);
    }

    @Override
    public void add(Prodotto prodotto) {
        this.prodottoRepository.save(prodotto);
    }

    @Override
    public List<Prodotto> findByNome(String nome) {
        return this.prodottoRepository.findByNome(nome);
    }

    @Override
    public void deleteById(Long id) {
        this.prodottoRepository.deleteById(id);
    }
}//end class
