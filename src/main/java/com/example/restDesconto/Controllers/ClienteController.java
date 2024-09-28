package com.example.restDesconto.Controllers;

import com.example.restDesconto.Services.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ufes.br.pedido.Cliente;

import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> ListCliente() {
        ClienteService clienteService = new ClienteService();

        return clienteService.listarClientes();
    }

    @PostMapping("/clientes")
    public String Cadastro(@RequestBody Cliente dataClient) {
        ClienteService clienteService = new ClienteService();

        Cliente clienteAux = new Cliente(
                dataClient.getNome(),
                dataClient.getTipo(),
                dataClient.getFidelidade(),
                dataClient.getLogradouro(),
                dataClient.getBairro(),
                dataClient.getCidade()
        );

        clienteService.criarCliente(clienteAux);

        return "Cliente cadastrado com sucesso!";

    }
}
