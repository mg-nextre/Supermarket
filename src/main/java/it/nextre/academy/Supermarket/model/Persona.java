package it.nextre.academy.Supermarket.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@MappedSuperclass
public abstract class Persona {

    public static enum Sesso{
        UOMO,DONNA,ALTRO
    }

    private String nome;
    private String cognome;
    private Integer eta;
    private Sesso sesso;

}//end class
