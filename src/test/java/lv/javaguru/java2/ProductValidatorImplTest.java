package lv.javaguru.java2;

import lv.javaguru.java2.Domain.Product;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.Validator.ProductValidator;
import lv.javaguru.java2.Validator.ProductValidatorImpl;
import lv.javaguru.java2.DTO.Error;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ProductValidatorImplTest {

    private Database database;
    private ProductValidator validator;

    @Before
    public void init() {
        database = Mockito.mock(Database.class);
        validator = new ProductValidatorImpl(database);
    }

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
