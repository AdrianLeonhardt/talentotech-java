package com.techlab.proyectofinal.service;

import com.techlab.proyectofinal.entity.Product;
import com.techlab.proyectofinal.repository.ProductRepository;
import com.techlab.proyectofinal.utils.StringUtils;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final StringUtils stringUtils;

  public ProductService(ProductRepository productRepository, StringUtils stringUtils) {
    this.productRepository = productRepository;
    this.stringUtils = stringUtils;
  }

  public Product createProduct(Product product) {
    System.out.println("Producto Ingresado: " + product);
    return this.productRepository.save(product);
  }

  public Product getProductById(Long id){
    Optional<Product> productOptional = this.productRepository.findById(id);
    if (productOptional.isEmpty()){
      throw new RuntimeException("Producto no encontrado con ese id: " + id);
    }
    return productOptional.get();
  }

  public List<Product> findAllProducts(String name, String category) {
    if (!name.isEmpty() && !category.isEmpty()){
      return this.productRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
    }

    if (!name.isEmpty()){
      return  this.productRepository.findByNameContainingIgnoreCase(name);
    }

    if (!category.isEmpty()){
      return this.productRepository.findByCategoryContainingIgnoreCase(category);
    }

    return this.productRepository.findAll();
  }

  public Product editProductById(Long id, Product dataToEdit){
    Product product = this.getProductById(id);

    // Actualizar Nombre
    if (!stringUtils.isEmpty(dataToEdit.getName())) {
      product.setName(dataToEdit.getName());
    }

    // Actualizar Categoría
    if (!stringUtils.isEmpty(dataToEdit.getCategory())) {
      product.setCategory(dataToEdit.getCategory());
    }

    // Actualizar Precio
    if (dataToEdit.getPrice() != null) {
      product.setPrice(dataToEdit.getPrice());
    }

    // --- AGREGAR ESTO AQUÍ ABAJO ---
    // Actualizar Stock
    if (dataToEdit.getStock() != null) {
      product.setStock(dataToEdit.getStock());
    }

    // Actualizar Imagen (Si agregaste el campo imageUrl)
    if (dataToEdit.getImageUrl() != null) {
      product.setImageUrl(dataToEdit.getImageUrl());
    }
    // -------------------------------

    return this.productRepository.save(product);
  }

  public Product deleteProductById(Long id){
    Product product = this.getProductById(id);
    this.productRepository.delete(product);
    return product;
  }

}