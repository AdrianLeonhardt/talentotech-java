package com.techlab;

import com.techlab.excepciones.NumeroInvalidoException;
import com.techlab.pedidos.Pedido;
import com.techlab.productos.Producto;
import com.techlab.servicio.ProductoService;
import com.techlab.servicio.PedidoService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Inicio {

  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    List<Producto> productos = new ArrayList<>();
    List<Pedido> pedidos = new ArrayList<>();
    ProductoService productoService = new ProductoService();
    PedidoService pedidoService = new PedidoService();

    int opcion;

    while (true) {
      mostrarMenu();

      try {
        System.out.print("Elija una opción: ");
        opcion = teclado.nextInt();
        teclado.nextLine();

        if (opcion < 0 || opcion > 7) {
          throw new NumeroInvalidoException("Opción inválida: " + opcion);
        }

        switch (opcion) {
          case 0 -> {
            System.out.println("Agregar producto...");
            productoService.agregarProducto(teclado, productos);
          }
          case 1 -> {
            System.out.println("Listar productos...");
            if (productos.isEmpty()) {
              System.out.println("⚠️ No hay productos cargados.");
            } else {
              for (Producto p : productos) {
                System.out.println(p);
              }
            }
          }
          case 2 -> {
            System.out.println("Buscar producto...");
            productoService.buscarProductoPorNombre(teclado, productos);
          }
          case 3 -> {
            System.out.println("Actualizar producto...");
            productoService.actualizarProducto(teclado, productos);
          }
          case 4 -> {
            System.out.println("Eliminar producto...");
            productoService.eliminarProducto(teclado, productos);
          }
          case 5 -> pedidoService.crearPedido(teclado, productos, pedidos);
          case 6 -> pedidoService.listarPedidos(pedidos);
          case 7 -> {
            System.out.println("Saliendo del sistema...");
            teclado.close();
            return;
          }
        }

      } catch (InputMismatchException e) {
        System.out.println("Error: Debe ingresar un número.");
        teclado.nextLine(); // limpiar buffer
      } catch (NumeroInvalidoException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private static void mostrarMenu() {
    System.out.println("""
                
                Ingrese el número equivalente a la opción:
                  + 0 - Agregar producto
                  + 1 - Listar productos
                  + 2 - Buscar producto
                  + 3 - Actualizar producto
                  + 4 - Eliminar producto
                  + 5 - Crear un pedido
                  + 6 - Listar pedidos
                  + 7 - Salir
                """);
  }
}


