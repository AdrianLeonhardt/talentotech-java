package com.techlab.productos;

public class Producto {
  // Atributos
  private int id;
  private static int idContador = 1;
  private String nombre;
  private double precio;
  private int stock;

  // Constructor
  public Producto(String nombre, double precio, int stock) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
    this.id = idContador++;
  }

  // Getters (Lee Valores)
  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public int getStock() {
    return stock;
  }

  // Setters (Modifica Valores)
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  // Método para mostrar información del producto
  @Override
  public String toString() {
    return String.format("ID: %d | Nombre: %s | Precio: $%.2f | Stock: %d", id, nombre, precio, stock);
  }
}
