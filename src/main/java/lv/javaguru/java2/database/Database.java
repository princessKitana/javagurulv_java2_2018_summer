package lv.javaguru.java2.database;

import lv.javaguru.java2.Domain.Product;
import lv.javaguru.java2.Domain.Trip;
import lv.javaguru.java2.Domain.User;

import java.util.List;
import java.util.Optional;

public interface Database {
    void addProduct(Product product);

    Optional<Product> getByTitle(String title);

    boolean remove(Product product);

    List<Product> getAllProducts();

    void addTrip(Trip trip);

    void registerUser(User user);
}
