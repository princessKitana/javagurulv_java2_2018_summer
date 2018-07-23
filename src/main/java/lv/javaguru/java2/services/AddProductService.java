package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.Domain.Product;

import java.sql.Date;

public class AddProductService {

    private Database database;

    public AddProductService(Database database) {
        this.database = database;
    }

    public void addProduct(String title, String description) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        product.setDate_added(date);
        database.addProduct(product);
    }

}
