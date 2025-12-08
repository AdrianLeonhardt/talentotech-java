package com.techlab.proyectofinal.service;

import com.techlab.proyectofinal.dto.ProductoPedidoRequest;
import com.techlab.proyectofinal.entity.LineaPedido;
import com.techlab.proyectofinal.entity.Pedido;
import com.techlab.proyectofinal.entity.Product;
import com.techlab.proyectofinal.exception.StockInsuficienteException;
import com.techlab.proyectofinal.repository.PedidoRepository;
import com.techlab.proyectofinal.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

  private final PedidoRepository pedidoRepository;
  private final ProductRepository productRepository;

  public PedidoService(PedidoRepository pedidoRepository, ProductRepository productRepository) {
    this.pedidoRepository = pedidoRepository;
    this.productRepository = productRepository;
  }

  @Transactional
  public Pedido crearPedido(List<ProductoPedidoRequest> itemsSolicitados) {

    Pedido pedido = new Pedido();
    pedido.setFecha(LocalDateTime.now());
    pedido.setEstado("PENDIENTE");

    Double totalCalculado = 0.0;

    for (ProductoPedidoRequest item : itemsSolicitados) {
      // 1. Buscar el producto en la BD
      Product producto = productRepository.findById(item.getProductoId())
          .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + item.getProductoId()));

      // 2. Validar Stock
      if (producto.getStock() < item.getCantidad()) {
        throw new StockInsuficienteException("No hay suficiente stock para el producto: " + producto.getName());
      }

      // 3. Restar Stock (Esto cumple el requerimiento de actualizar stock)
      producto.setStock(producto.getStock() - item.getCantidad());
      // Guardamos el cambio de stock inmediatamente (opcional si usas Transactional, pero seguro)
      productRepository.save(producto);

      // 4. Crear la línea de pedido
      LineaPedido linea = new LineaPedido();
      linea.setProduct(producto);
      linea.setCantidad(item.getCantidad());
      linea.setPrecioUnitario(producto.getPrice()); // Guardamos el precio histórico

      // 5. Vincular al pedido
      pedido.agregarLinea(linea);

      // 6. Sumar al total
      totalCalculado += linea.getSubtotal();
    }

    pedido.setTotal(totalCalculado);

    // 7. Guardar el pedido (esto guarda también las líneas por el Cascade)
    return pedidoRepository.save(pedido);
  }

  // Método extra para listar pedidos (Requerimiento: Historial)
  public List<Pedido> obtenerTodosLosPedidos() {
    return pedidoRepository.findAll();
  }
}