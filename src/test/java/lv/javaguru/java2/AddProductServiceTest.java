package lv.javaguru.java2;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.DTO.AddProductResponse;
import lv.javaguru.java2.services.AddProductService;
import lv.javaguru.java2.Validator.ProductValidator;
import lv.javaguru.java2.DTO.Error;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddProductServiceTest {

    private ProductValidator validator;
    private Database database;
    private AddProductService service;

    @Before
    public void init() {
        validator = Mockito.mock(ProductValidator.class);
        database = Mockito.mock(Database.class);
        service = new AddProductService(validator, database);
    }

    @Test
    public void shouldReturnFailedResponseWhenValidationErrorsExist() {
        List<Error> errors = Collections.singletonList(
                new Error("title", "must be not empty")
        );

        Mockito.when(validator.validate(null, "desc"))
                .thenReturn(errors);

        AddProductResponse response = service.addProduct(null, "desc");

        assertFalse(response.isSussess());
    }

    @Test
    public void shouldReturnSuccessWhenValidationErrorsNotExist() {
        List<Error> errors = new ArrayList<>();
        Mockito.when(validator.validate("title", "desc"))
                .thenReturn(errors);

        AddProductResponse response = service.addProduct("title", "desc");

        assertTrue(response.isSussess());
    }
}
