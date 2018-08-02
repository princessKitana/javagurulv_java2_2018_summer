package lv.javaguru.java2.serviceTests;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.validator.ProductValidator;
import lv.javaguru.java2.validator.ProductValidatorImpl;
import lv.javaguru.java2.dto.Error;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ProductValidatorImplTest {

    @Mock
    private Database database;

    @InjectMocks
    private ProductValidator validator = new ProductValidatorImpl();


    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        List<Error> errors = validator.validate(null, "desc");

        assertEquals(1, errors.size());
        assertEquals("title", errors.get(0).getField() );
        assertEquals( "Cannot be empty", errors.get(0).getDescription());
    }

    @Test
    public void shouldReturnErrorWhenTitleIsEmpty() {
        List<Error> errors = validator.validate("", "desc");

        assertEquals(1, errors.size());
        assertEquals("title", errors.get(0).getField() );
        assertEquals( "Cannot be empty", errors.get(0).getDescription());
    }

    @Test
    public void shouldReturnErrorWhenDescriptionIsEmpty() {
        List<Error> errors = validator.validate("nggfgf", "");

        assertEquals(1, errors.size());
        assertEquals("description", errors.get(0).getField() );
        assertEquals( "Cannot be empty", errors.get(0).getDescription());
    }

    @Test
    public void shouldReturnErrorWhenDescriptionIsNull() {
        List<Error> errors = validator.validate("nggfgf", null);

        assertEquals(1, errors.size());
        assertEquals("description", errors.get(0).getField() );
        assertEquals( "Cannot be empty", errors.get(0).getDescription());
    }

    @Test
    public void shouldReturnErrorWhenProductAlreadyExistInDatabase() {
        Product existingFromDb = new Product();

        Mockito.when(database.getByTitle("title"))
                .thenReturn(Optional.of(existingFromDb));

        List<Error> errors = validator.validate("title", "dec");

        assertEquals(1, errors.size(), 1);
        assertEquals("title", errors.get(0).getField());
        assertEquals("Duplicates not allowed", errors.get(0).getDescription());
    }
}
