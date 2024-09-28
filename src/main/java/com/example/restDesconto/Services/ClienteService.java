package com.example.restDesconto.Services;

import ch.qos.logback.core.net.server.Client;
import com.example.restDesconto.Repositories.ClienteRepository;
import ufes.br.pedido.Cliente;

import java.util.List;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(){
        clienteRepository = ClienteRepository.getInstance();
    }

    public Cliente buscarClientePorId(int id){
        return this.listarClientes().stream().filter(cliente -> cliente.getId() == id).findFirst().orElse(null);
    }

    public List<Cliente> listarClientes() {
        return this.clienteRepository.getListaClientes();
    }

    public void criarCliente(Cliente cliente){
        cliente.setId(this.clienteRepository.getListaClientes().toArray().length);

        this.clienteRepository.criarCliente(cliente);
    }
}
