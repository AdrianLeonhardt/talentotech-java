package com.techlab.servicio;
import java.util.ArrayList;
import com.techlab.productos.Producto;
import java.util.List;
import java.util.Scanner;

public class ProductoService {

  public void agregarProducto(Scanner teclado, List<Producto> productos) {
    String nombre;
    double precio;
    int stock;

    System.out.println("Ingrese un nuevo producto");

    System.out.print("Nombre: ");
    nombre = teclado.nextLine();

    System.out.print("Precio: ");
    precio = teclado.nextDouble();
    teclado.nextLine();

    System.out.print("Stock: ");
    stock = teclado.nextInt();
    teclado.nextLine();

    Producto nuevoProducto = new Producto(nombre, precio, stock);
    productos.add(nuevoProducto);

    System.out.println("✅ Producto agregado con éxito: " + nuevoProducto);
  }

  public void eliminarProducto(Scanner teclado, List<Producto> productos) {
    if (productos.isEmpty()) {
      System.out.println("⚠️ No hay productos para eliminar.");
      return;
    }

    System.out.print("Ingrese el ID del producto a eliminar: ");
    int idEliminar = teclado.nextInt();
    teclado.nextLine();

    Producto productoAEliminar = null;

    // Buscar producto por ID
    for (Producto p : productos) {
      if (p.getId() == idEliminar) {
        productoAEliminar = p;
        break;
      }
    }

    if (productoAEliminar != null) {
      productos.remove(productoAEliminar);
      System.out.println("✅ Producto eliminado con éxito: " + productoAEliminar);
    } else {
      System.out.println("❌ No se encontró un producto con ID: " + idEliminar);
    }
  }

  public void buscarProductoPorNombre(Scanner teclado, List<Producto> productos) {
    if (productos.isEmpty()) {
      System.out.println("⚠️ No hay productos para buscar.");
      return;
    }

    System.out.print("Ingrese el nombre o parte del nombre del producto: ");
    String busqueda = teclado.nextLine().toLowerCase();

    List<Producto> encontrados = new ArrayList<>();

    for (Producto producto : productos) {
      if (producto.getNombre().toLowerCase().contains(busqueda)) {
        encontrados.add(producto);
      }
    }

    if (encontrados.isEmpty()) {
      System.out.println("❌ No se encontraron productos con ese nombre.");
    } else {
      System.out.println("✅ Productos encontrados:");
      for (Producto p : encontrados) {
        System.out.println(p);
      }
    }
  }

  public void actualizarProducto(Scanner teclado, List<Producto> productos) {
    if (productos.isEmpty()) {
      System.out.println("⚠️ No hay productos para actualizar.");
      return;
    }

    System.out.print("Ingrese el ID del producto a actualizar: ");
    int idActualizar = teclado.nextInt();
    teclado.nextLine();

    Producto productoActualizar = null;

    // Buscar producto por ID
    for (Producto p : productos) {
      if (p.getId() == idActualizar) {
        productoActualizar = p;
        break;
      }
    }

    if (productoActualizar == null) {
      System.out.println("❌ No se encontró un producto con ID: " + idActualizar);
      return;
    }

    System.out.println("Producto encontrado: " + productoActualizar);

    System.out.print("Nuevo nombre (enter para mantener '" + productoActualizar.getNombre() + "'): ");
    String nuevoNombre = teclado.nextLine();
    if (!nuevoNombre.isBlank()) {
      productoActualizar.setNombre(nuevoNombre);
    }

    System.out.print("Nuevo precio (enter para mantener " + productoActualizar.getPrecio() + "): ");
    String precioInput = teclado.nextLine();
    if (!precioInput.isBlank()) {
      try {
        double nuevoPrecio = Double.parseDouble(precioInput);
        productoActualizar.setPrecio(nuevoPrecio);
      } catch (NumberFormatException e) {
        System.out.println("Precio inválido, no se actualizó.");
      }
    }

    System.out.print("Nuevo stock (enter para mantener " + productoActualizar.getStock() + "): ");
    String stockInput = teclado.nextLine();
    if (!stockInput.isBlank()) {
      try {
        int nuevoStock = Integer.parseInt(stockInput);
        productoActualizar.setStock(nuevoStock);
      } catch (NumberFormatException e) {
        System.out.println("Stock inválido, no se actualizó.");
      }
    }

    System.out.println("✅ Producto actualizado: " + productoActualizar);
  }

}



