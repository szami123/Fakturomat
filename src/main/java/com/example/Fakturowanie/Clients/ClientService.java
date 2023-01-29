package com.example.Fakturowanie.Clients;

import com.example.Fakturowanie.Clients.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;





import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;


    public List<Client> showClient() {
        return clientRepository.findAll();


    }
    public Client addCustomer(Client client){

        return clientRepository.save(client);

    }

    public Optional<Client> foundClients(Long id){

        return clientRepository.findById(id);

    }



}
