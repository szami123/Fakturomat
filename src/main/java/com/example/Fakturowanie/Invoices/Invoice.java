package com.example.Fakturowanie.Invoices;


import com.example.Fakturowanie.Clients.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice {

    public Invoice(Client klient, Date data_utworzenia, Double cena_na_fakturze) {
        this.client = klient;
        this.data = data_utworzenia;
        this.kwota = cena_na_fakturze;
    }


    @SequenceGenerator(
            name = "invoiceSequence",
            sequenceName = "invoiceSequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoiceSequence"
    )

    private Long id;

    @OneToOne
    private Client client;

    @Column(updatable = false)
    private String numer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(updatable = false)
    private double kwota;




}
