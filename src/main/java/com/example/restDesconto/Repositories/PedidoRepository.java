package com.example.restDesconto.Repositories;

import ufes.br.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private static PedidoRepository instance;
    private List<Pedido> listaPedidos;

    private PedidoRepository() {
        listaPedidos = new ArrayList<>();
    }

    public static PedidoRepository getInstance() {
        if (instance == null) {
            instance = new PedidoRepository();
        }

        return instance;
    }

    public Pedido buscaPedido(int id){
        return this.listaPedidos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void criaPedido(Pedido pedido){
        pedido.setId(listaPedidos.toArray().length);

        listaPedidos.add(pedido);
    }

    public void atualizaPedido(int position, Pedido pedido){
        listaPedidos.set(position, pedido);
    }


}
