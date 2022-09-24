package br.com.itau.apitransfer.service;

import br.com.itau.apitransfer.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client createClient(Client client);

    List<Client> getClients();

    Optional<Client> getByAccount(Long accountNumber);
}