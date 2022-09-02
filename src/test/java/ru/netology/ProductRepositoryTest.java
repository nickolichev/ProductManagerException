package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

  private final ProductRepository repository = new ProductRepository();
  Product productBook = new Product(200, 11, "Printed");
  Product productSmartphone = new Product(45, 22, "Electronic");
  Product Bestseller = new Book(50, 1101, "HistoricalLiterature ", "Bestseller");
  Product Detective = new Book(450, 1102, "EnglishWriters", "Detective");
  Product Poetry = new Book(65, 1103, "ClassicLiterature", "Poetry");
  Product IPhone = new Smartphone(450, 2201, "ElectronicSectionOne", "IPhone 13 Pro");
  Product Samsung = new Smartphone(350, 450, "ElectronicSectionOne", "Samsung Galaxy S22");
  Product Nokia = new Smartphone(280, 2203, "ElectronicSectionSale", "Nokia XR 20");

  @BeforeEach
  void saveAll() {
    repository.save(productBook);
    repository.save(productSmartphone);
    repository.save(Bestseller);
    repository.save(Detective);
    repository.save(Poetry);
    repository.save(IPhone);
    repository.save(Samsung);
    repository.save(Nokia);
  }

  // Задача #1
  @Test //Проверка успешности удаления существующего элемента
  public void removeProductsById() {
    repository.removeById(1101);
    repository.removeById(2201);
    repository.removeById(2203);

    Product[] actual = repository.findAll();
    Product[] expected = {productBook, productSmartphone, Detective, Poetry, Samsung};

    Assertions.assertArrayEquals(expected, actual);
  }

  @Test // генерация NotFoundException при попытке удаления несуществующего элемента
  public void removeNotFoundProductById() {
    repository.removeById(1105);

    assertThrows(NotFoundException.class, () -> {repository.removeById(1105);});
  }
}