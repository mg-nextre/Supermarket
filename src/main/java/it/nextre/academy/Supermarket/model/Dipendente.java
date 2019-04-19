package it.nextre.academy.Supermarket.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "DIPENDENTE", uniqueConstraints = @UniqueConstraint(name = "UNIQUE_IBAN",columnNames={"iban"}))
public class Dipendente extends Persona{

    public enum Ruolo{
        IMPIEGATO,MANAGER,DIRETTORE
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Ruolo ruolo;
    @NotNull
    private String iban;

    public Dipendente(String nome, String cognome, Integer eta, Sesso sesso, Ruolo ruolo, String iban) {
        super(nome, cognome, eta, sesso);
        this.ruolo = ruolo;
        this.iban = iban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dipendente that = (Dipendente) o;
        return getRuolo() == that.getRuolo() &&
                Objects.equals(getIban(), that.getIban());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRuolo(), getIban());
    }
}//end class
