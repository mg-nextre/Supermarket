package it.nextre.academy.Supermarket.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PRODOTTO", uniqueConstraints = @UniqueConstraint(name = "UNIQUE_CODICE_PRODOTTO",columnNames={"codiceProdotto"}))
public class Prodotto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    private BigDecimal prezzo;
    @NotNull
    @Column(length = 250)
    private String codiceProdotto;

    public Prodotto(String nome,BigDecimal prezzo, String codiceProdotto){
        this.nome = nome;
        this.prezzo = prezzo;
        this.codiceProdotto = codiceProdotto;
    }

    @Override
    public Prodotto clone() throws CloneNotSupportedException {
        return new Prodotto(nome,prezzo,codiceProdotto);
    }
}//end class
