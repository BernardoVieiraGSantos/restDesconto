package com.example.restDesconto.Repositories;

import ufes.br.pedido.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static ClienteRepository instance;
    private List<Cliente> listaClientes;

    private ClienteRepository() {
        listaClientes = new ArrayList<>();
    }

    public static ClienteRepository getInstance(){
        if(ClienteRepository.instance == null ){
            ClienteRepository.instance = new ClienteRepository();
        }

        return ClienteRepository.instance;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void criarCliente(Cliente cliente){
        this.listaClientes.add(cliente);
    }

}
