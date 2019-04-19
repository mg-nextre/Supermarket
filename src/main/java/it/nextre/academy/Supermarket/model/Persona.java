package it.nextre.academy.Supermarket.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@MappedSuperclass
public abstract class Persona {

    public enum Sesso{
        UOMO,DONNA,ALTRO
    }

    private String nome;
    private String cognome;
    private Integer eta;
    private Sesso sesso;

}//end class
