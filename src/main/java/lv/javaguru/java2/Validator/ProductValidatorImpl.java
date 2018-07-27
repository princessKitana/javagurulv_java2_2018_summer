package lv.javaguru.java2.Validator;

import lv.javaguru.java2.DTO.Error;
import lv.javaguru.java2.Domain.Product;
import lv.javaguru.java2.database.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductValidatorImpl implements ProductValidator {

    private Database database;

    public ProductValidatorImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Error> validate(String title, String description) {
        List<Error> errors = new ArrayList<>();
        checkTitleNotBlank(title, errors);
        checkDescriptionNotBlank(description, errors);
        checkProductDuplicates(title, errors);
        return errors;
    }

    private void checkProductDuplicates(String title, List<Error> errors) {
        if (title != null && !title.isEmpty()) {
            Optional<Product> productOpt = database.getByTitle(title);
            if (productOpt.isPresent()) {
                Error error = new Error("title", "Duplicates not allowed");
                errors.add(error);
            }
        }
    }

    private void checkDescriptionNotBlank(String description, List<Error> errors) {
        if (description == null || description.isEmpty()) {
            Error error = new Error("description", "Cannot be empty");
            errors.add(error);
        }
    }

    private void checkTitleNotBlank(String title,
                                        List<Error> errors) {
        if (title == null || title.isEmpty()) {
            Error error = new Error("title", "Cannot be empty");
            errors.add(error);
        }
    }

}
