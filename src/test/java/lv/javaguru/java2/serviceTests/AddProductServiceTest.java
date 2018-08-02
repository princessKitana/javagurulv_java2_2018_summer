package lv.javaguru.java2.serviceTests;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.dto.AddProductResponse;
import lv.javaguru.java2.services.AddProductService;
import lv.javaguru.java2.validator.ProductValidator;
import lv.javaguru.java2.dto.Error;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddProductServiceTest {

    @Mock
    private ProductValidator validator;
    @Mock
    private Database database;

    @InjectMocks
    private AddProductService service = new AddProductService();


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
