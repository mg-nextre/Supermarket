package it.nextre.academy.Supermarket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "FORNITORI", uniqueConstraints = @UniqueConstraint(name = "UNIQUE_PARTITA_IVA",columnNames={"partitaIva"}))
public class Fornitori extends Persona{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(length = 250)
    private String partitaIva;
    private BigDecimal fatturato;

    public Fornitori(String nome, String cognome, Integer eta, Sesso sesso, String partitaIva, BigDecimal fatturato) {
        super(nome, cognome, eta, sesso);
        this.partitaIva = partitaIva;
        this.fatturato = fatturato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fornitori fornitori = (Fornitori) o;
        return Objects.equals(getPartitaIva(), fornitori.getPartitaIva()) &&
                Objects.equals(getFatturato(), fornitori.getFatturato());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPartitaIva(), getFatturato());
    }
}//end class
