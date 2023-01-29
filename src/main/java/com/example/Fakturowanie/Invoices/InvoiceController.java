package com.example.Fakturowanie.Invoices;


import com.example.Fakturowanie.Clients.Client;
import com.example.Fakturowanie.Clients.ClientService;
import lombok.AllArgsConstructor;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@AllArgsConstructor
public class InvoiceController {

private final ClientService clientService;
private final InvoiceService invoiceService;



    @GetMapping("/addInvoice/{id}")
    public String addInvoice(Model model, @PathVariable("id") Long id) {
        Client client = clientService.foundClients(id).orElse(null);
        model.addAttribute(new Invoice());
        model.addAttribute("client", client);
        model.addAttribute(new InvoiceDTO());

        return "addInvoice";
    }


    @PostMapping("/invoiceHasBeenAdded")
    public String invoiceHasBeenAdded(InvoiceDTO invoiceDTO) {
        Client client = clientService.foundClients(invoiceDTO.getIdClient()).orElseThrow(() -> {throw new NoSuchElementException("Nie znaleziono produktu");});

        Invoice invoice = new Invoice(client, LocalDate.parse(invoiceDTO.getData_utworzenia()).toDate(), invoiceDTO.getKwota_faktury());
        Invoice newinvoice= invoiceService.addInvoice(invoice);
        return "index";
    }


    @GetMapping("/listInvoices")
    public String invoiceList(Model model) {
        List<Invoice> invoiceList = invoiceService.showInvoice();
        model.addAttribute("towarek", invoiceList);
        return "invoiceList";
    }

}






