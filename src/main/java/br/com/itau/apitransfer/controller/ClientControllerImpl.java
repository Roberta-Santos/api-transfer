package br.com.itau.apitransfer.controller;

import br.com.itau.apitransfer.entity.Client;
import br.com.itau.apitransfer.service.ClientService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Api(tags = "Clientes")
@RestController
public class ClientControllerImpl implements ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientControllerImpl.class);

    @Autowired
    private ClientService clientService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Client addClient(Client client) {
        logger.info("Cadastrando novo cliente.");
        return clientService.createClient(client);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@Override
    public ResponseEntity<?> getClients() {
        List<Client> clients = clientService.getClients();
        logger.info("Listando clientes cadastrados.");
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping(path = "/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
@Override
    public Optional<Client> getByAccount(@PathVariable("accountNumber") Long accountNumber) {
        logger.info("Buscando cliente pelo número da conta '{}'.", accountNumber);
        return clientService.getByAccount(accountNumber);
    }
}
