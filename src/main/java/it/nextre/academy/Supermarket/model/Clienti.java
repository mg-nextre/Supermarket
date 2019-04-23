package it.nextre.academy.Supermarket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CLIENTI", uniqueConstraints = @UniqueConstraint(name = "UNIQUE_CODICE_CARTA_PUNTI",columnNames={"codiceCartaPunti"}))
public class Clienti extends Persona{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(length = 250)
    private String codiceCartaPunti;
    private BigDecimal budgetDiSpesa;

    public Clienti(String nome, String cognome, Integer eta, Sesso sesso, String codiceCartaPunti, BigDecimal budgetDiSpesa) {
        super(nome, cognome, eta, sesso);
        this.codiceCartaPunti = codiceCartaPunti;
        this.budgetDiSpesa = budgetDiSpesa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Clienti clienti = (Clienti) o;
        return Objects.equals(getCodiceCartaPunti(), clienti.getCodiceCartaPunti()) &&
                Objects.equals(getBudgetDiSpesa(), clienti.getBudgetDiSpesa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCodiceCartaPunti(), getBudgetDiSpesa());
    }
}//end class
