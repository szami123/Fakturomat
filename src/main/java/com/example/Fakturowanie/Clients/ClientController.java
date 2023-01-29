package com.example.Fakturowanie.Clients;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {
private final ClientService clientService;


    @GetMapping("/clients")
    public String clients(Model model) {
        List<Client> Clients = clientService.showClient();
        model.addAttribute("klienci", Clients);
        return "clientList";
    }


    @GetMapping("/addclient")
    public String addClient(Model model) {
        model.addAttribute(new Client());
        return "addClient";
    }

    @PostMapping("/clientadd")
    public String clientAdd(Client client) {

        Client newClient = clientService.addCustomer(client);
        return "addclient";
    }


}
