package com.example.Fakturowanie.Clients;

import lombok.*;


import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @SequenceGenerator(
            name = "clientSequence",
            sequenceName = "clientSequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clientSequence"
    )
    private Long id;
    @Column(updatable = false)

    private String imie;
    @Column(updatable = false)
    private String nazwisko_nazwa;

    @Column(updatable = false)
    private String miejscowosc;

    @Column(updatable = false)
    private String ulica;

    @Column(updatable = false)
    private String numer_budynku;

    @Column( updatable = false)
    private String kod_pocztowy;

    @Column(updatable = false)
    private String email;

    @Column(updatable = false)
    private String telefon;

    @Column(updatable = false)
    private String NIP;


}
