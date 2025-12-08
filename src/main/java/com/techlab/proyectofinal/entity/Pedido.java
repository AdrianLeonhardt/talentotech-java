package com.techlab.proyectofinal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime fecha;

  private Double total;

  private String estado;


  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private List<LineaPedido> lineas = new ArrayList<>();

  // Un método helper para agregar líneas fácilmente y mantener la relación
  public void agregarLinea(LineaPedido linea) {
    lineas.add(linea);
    linea.setPedido(this);
  }
}