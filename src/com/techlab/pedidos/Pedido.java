package com.techlab.pedidos;

import java.util.List;

public class Pedido {
  private static int contadorId = 1;

  private int id;
  private List<LineaPedido> lineasPedido;

  public Pedido(List<LineaPedido> lineasPedido) {
    this.id = contadorId++;
    this.lineasPedido = lineasPedido;
  }

  public int getId() {
    return id;
  }

  public List<LineaPedido> getLineasPedido() {
    return lineasPedido;
  }

  public double calcularTotal() {
    return lineasPedido.stream()
        .mapToDouble(LineaPedido::getSubtotal)
        .sum();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Pedido ID: ").append(id).append("\n");
    for (LineaPedido lp : lineasPedido) {
      sb.append("  - ").append(lp).append("\n");
    }
    sb.append("Total: $").append(calcularTotal());
    return sb.toString();
  }
}
