package br.com.itau.apitransfer.service;

import br.com.itau.apitransfer.entity.Client;
import br.com.itau.apitransfer.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getByAccount(Long accountNumber) {
        return clientRepository.findById(accountNumber);
    }
}
