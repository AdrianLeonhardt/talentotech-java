package com.techlab.proyectofinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoPedidoRequest {
  private Long productoId;
  private Integer cantidad;
}
