package lv.javaguru.java2.services;

import lv.javaguru.java2.DTO.AddProductResponse;
import lv.javaguru.java2.DTO.Error;
import lv.javaguru.java2.Validator.ProductValidator;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.Domain.Product;

import java.sql.Date;
import java.util.List;

public class AddProductService {

    private Database database;
    private ProductValidator validator;

    public AddProductService(ProductValidator validator,
                             Database database) {
        this.validator = validator;
        this.database = database;
    }

    public AddProductService(Database database) {
        this.database = database;
    }

    public AddProductResponse addProduct(String title, String description) {
        List<Error> validationErrors = validator.validate(title, description);

        if (!validationErrors.isEmpty()) {
            return new AddProductResponse(validationErrors);
        }
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        product.setDate_added(date);
        database.addProduct(product);

        return new AddProductResponse(product.getId());
    }

}
