package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

  ProductRepository repository = new ProductRepository();
  ProductManager manager = new ProductManager(repository);

  Product Bestseller = new Book(50, 1101, "HistoricalLiterature ", "Bestseller");
  Product Detective = new Book(450, 1102, "EnglishWriters", "Detective");
  Product Poetry = new Book(65, 1103, "ClassicLiterature", "Poetry");
  Product IPhone = new Smartphone(450, 2201, "ElectronicSectionOne", "IPhone 13 Pro");
  Product Samsung = new Smartphone(350, 450, "ElectronicSectionOne", "Samsung Galaxy S22");
  Product Nokia = new Smartphone(280, 2203, "ElectronicSectionSale", "Nokia XR 20");

  @BeforeEach
  void addProducts() {
    manager.add(Bestseller);

  }

  // Задача #2
  @Test //Проверка успешности добавления новых товаров
  public void addNewProducts() {
    manager.add(Detective);
    manager.add(Poetry);
    manager.add(IPhone);
    manager.add(Samsung);
    manager.add(Nokia);

    Product[] actual = repository.findAll();
    Product[] expected = {Bestseller, Detective, Poetry, IPhone, Samsung, Nokia};

    assertArrayEquals(expected, actual);

  }

  @Test // генерация AlreadyExistsException при попытке добавить элемент с повторяющимся id
  public void addAlreadyExistsProductById() {
    manager.add(Bestseller);

    assertThrows(AlreadyExistsException.class, () -> {
      manager.add(Bestseller);
    });
  }
}