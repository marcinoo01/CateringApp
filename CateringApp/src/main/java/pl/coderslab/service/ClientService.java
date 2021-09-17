package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Client;
import pl.coderslab.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void add(Client client){
        clientRepository.save(client);
    }
    public Optional<Client> findAllByUserId(Long id){
        return clientRepository.findByUserId(id);
    }

}
