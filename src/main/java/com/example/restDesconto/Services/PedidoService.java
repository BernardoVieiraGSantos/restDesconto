package com.example.restDesconto.Services;

import com.example.restDesconto.Repositories.PedidoRepository;
import ufes.br.pedido.Item;
import ufes.br.pedido.Pedido;

import java.util.List;

public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService() {
        this.pedidoRepository = PedidoRepository.getInstance();
    }

    public Pedido buscarPorId(int id) {
        return this.pedidoRepository.buscaPedido(id);
    }

    public void criarPedido(Pedido pedido, List<Item> itens) {

        for (Item item : itens) {
            pedido.adicionarItem(item);
        }

        this.pedidoRepository.criaPedido(pedido);
    }

}
