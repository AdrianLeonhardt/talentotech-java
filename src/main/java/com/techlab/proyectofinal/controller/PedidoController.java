package com.techlab.proyectofinal.controller;

import com.techlab.proyectofinal.dto.ProductoPedidoRequest;
import com.techlab.proyectofinal.entity.Pedido;
import com.techlab.proyectofinal.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class PedidoController {

  private final PedidoService pedidoService;

  public PedidoController(PedidoService pedidoService) {
    this.pedidoService = pedidoService;
  }

  // Endpoint para CREAR un pedido
  // POST /orders
  @PostMapping
  public Pedido crearPedido(@RequestBody List<ProductoPedidoRequest> items) {
    return pedidoService.crearPedido(items);
  }

  // Endpoint para ver el HISTORIAL
  // GET /orders
  @GetMapping
  public List<Pedido> obtenerPedidos() {
    return pedidoService.obtenerTodosLosPedidos();
  }
}
