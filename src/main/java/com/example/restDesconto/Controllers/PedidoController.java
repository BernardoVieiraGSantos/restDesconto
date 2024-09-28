package com.example.restDesconto.Controllers;

import com.example.restDesconto.Services.ClienteService;
import com.example.restDesconto.Services.PedidoService;
import org.springframework.web.bind.annotation.*;
import ufes.br.pedido.CalculadoraDescontoService;
import ufes.br.pedido.Cliente;
import ufes.br.pedido.Pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class PedidoController {

    @GetMapping("/pedidos/{pedidoId}")
    public Pedido consultaPedido(@PathVariable int pedidoId) {
        PedidoService pedidoService = new PedidoService();

        return pedidoService.buscarPorId(pedidoId);
    }

    @PostMapping("/pedidos/")
    public String cadastroPedido(@RequestBody PedidoRequestBody data) {
        ClienteService clienteService = new ClienteService();
        PedidoService pedidoService = new PedidoService();

        Cliente cliente = clienteService.buscarClientePorId(data.getClientId());

        Pedido pedido = new Pedido(data.getData() , cliente);

        pedidoService.criarPedido(pedido, data.getItens());

        return "Pedido criado com sucesso!";
    }

    @PostMapping("/pedidos/{pedidoId}/processar-descontos")
    public Pedido procesamento(@PathVariable int pedidoId) {
        PedidoService pedidoService = new PedidoService();
        CalculadoraDescontoService calculadoraDescontoService = new CalculadoraDescontoService();

        Pedido pedido = pedidoService.buscarPorId(pedidoId);

        calculadoraDescontoService.processar(pedido);

        return pedido;
    }
}
