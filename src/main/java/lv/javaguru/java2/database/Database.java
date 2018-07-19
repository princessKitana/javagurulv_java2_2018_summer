package lv.javaguru.java2.database;

import lv.javaguru.java2.Domain.Product;

import java.util.List;
import java.util.Optional;

public interface Database {
    void addProduct(Product product);

    Optional<Product> getByTitle(String title);

    boolean remove(Product product);

    List<Product> getAllProducts();
}
