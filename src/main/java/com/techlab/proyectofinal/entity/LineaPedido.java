package com.techlab.proyectofinal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter @Setter
public class LineaPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private Integer cantidad;

  private Double precioUnitario;

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  @JsonIgnore
  private Pedido pedido;

  public Double getSubtotal() {
    return this.precioUnitario * this.cantidad;
  }
}
