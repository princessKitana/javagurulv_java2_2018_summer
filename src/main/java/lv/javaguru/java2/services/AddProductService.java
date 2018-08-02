package lv.javaguru.java2.services;

import lv.javaguru.java2.dto.AddProductResponse;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.validator.ProductValidator;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class AddProductService {

    @Autowired
    private Database database;

    @Autowired
    private ProductValidator validator;

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
