package com.example.Fakturowanie.Invoices;


import lombok.Data;

import java.util.Date;

@Data
public class InvoiceDTO {

private Long idClient;

private String data_utworzenia;

private Double kwota_faktury;
}
