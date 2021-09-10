package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Client;
import pl.coderslab.repository.ClientRepository;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void add(Client client){
        clientRepository.save(client);
    }
}
