package ru.netology;

public class ProductRepository {
  private Product[] products = new Product[0];

  public void save(Product newProduct) {
    if (findById(newProduct.getId()) != null) {
      throw new AlreadyExistsException("Product with id: " + newProduct.getId() + " already exists in the repository");
    }
    Product[] tmp = new Product[products.length + 1];
    System.arraycopy(products, 0, tmp, 0, products.length);
    tmp[tmp.length - 1] = newProduct;
    products = tmp;
  }

  public Product findById(int id) {
    for (Product newProduct : products) {
      if (newProduct.getId() == id) {
        return newProduct;
      }
    }
    return null;
  }

  public void removeById(int id) {
    if (id < 0) {
      throw new NotFoundIdException("Product with id: " + id + " not found");
    } else {
      int length = products.length - 1;
      Product[] tmp = new Product[length];
      int index = 0;
      for (Product product : products) {
        if (product.getId() != id) {
          tmp[index] = product;
          index++;
        }
      }
      products = tmp;
    }
  }

  public Product[] findAll() {
    return products;
  }
}


