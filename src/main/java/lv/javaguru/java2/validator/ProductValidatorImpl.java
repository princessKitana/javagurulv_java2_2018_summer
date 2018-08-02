package lv.javaguru.java2.validator;

import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductValidatorImpl implements ProductValidator {

    @Autowired
    private Database database;

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
