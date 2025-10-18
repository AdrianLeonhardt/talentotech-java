package com.techlab.servicio;

import com.techlab.pedidos.LineaPedido;
import com.techlab.pedidos.Pedido;
import com.techlab.productos.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoService {

  public void crearPedido(Scanner teclado, List<Producto> productos, List<Pedido> pedidos) {
    List<LineaPedido> lineas = new ArrayList<>();

    System.out.println("Crear un nuevo pedido. Para terminar ingrese 0 en el ID.");

    while (true) {
      System.out.print("Ingrese ID del producto: ");
      int id = teclado.nextInt();
      if (id == 0) break;

      Producto producto = null;
      for (Producto p : productos) {
        if (p.getId() == id) {
          producto = p;
          break;
        }
      }

      if (producto == null) {
        System.out.println("Producto no encontrado.");
        continue;
      }

      System.out.print("Cantidad: ");
      int cantidad = teclado.nextInt();

      if (cantidad <= 0) {
        System.out.println("Cantidad inválida.");
        continue;
      }

      if (producto.getStock() < cantidad) {
        System.out.println("Stock insuficiente para el producto " + producto.getNombre());
        continue;
      }

      // Restar stock
      producto.setStock(producto.getStock() - cantidad);

      lineas.add(new LineaPedido(producto, cantidad));

      System.out.println("Producto agregado al pedido.");
    }

    if (lineas.isEmpty()) {
      System.out.println("No se agregaron productos al pedido. Pedido cancelado.");
      return;
    }

    Pedido pedido = new Pedido(lineas);
    pedidos.add(pedido);
    System.out.println("Pedido creado con éxito:");
    System.out.println(pedido);
  }

  public void listarPedidos(List<Pedido> pedidos) {
    if (pedidos.isEmpty()) {
      System.out.println("No hay pedidos realizados.");
      return;
    }

    System.out.println("Pedidos realizados:");
    for (Pedido p : pedidos) {
      System.out.println(p);
    }
  }
}


