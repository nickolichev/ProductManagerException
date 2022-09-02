package ru.netology;

public class ProductManager {

  private final ProductRepository repository;

  public ProductManager(ProductRepository repository) {
    this.repository = repository;
  }

  public void add(Product product) {
    repository.save(product);
  }
}