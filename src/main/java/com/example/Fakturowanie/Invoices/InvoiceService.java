package com.example.Fakturowanie.Invoices;


import com.example.Fakturowanie.Clients.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;


    public List<Invoice> showInvoice() {
        return invoiceRepository.findAll();


    }

    public Invoice addInvoice(Invoice invoice) {

        return invoiceRepository.save(invoice);

    }
    }
