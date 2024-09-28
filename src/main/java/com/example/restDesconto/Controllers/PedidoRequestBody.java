package com.example.restDesconto.Controllers;

import ufes.br.pedido.Item;

import java.time.LocalDate;
import java.util.List;

public class PedidoRequestBody {

    private int clientId;
    private LocalDate data;
    private List<Item> itens;

    public int getClientId() {
        return clientId;
    }

    public LocalDate getData() {
        return data;
    }

    public List<Item> getItens() {
        return itens;
    }
}
