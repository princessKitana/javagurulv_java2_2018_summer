package lv.javaguru.java2.database;

import lv.javaguru.java2.Domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements Database{
    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public Optional<Product> getByTitle(String title) {
        return products.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst();
    }

    @Override
    public boolean remove(Product product) {
        return products.remove(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
