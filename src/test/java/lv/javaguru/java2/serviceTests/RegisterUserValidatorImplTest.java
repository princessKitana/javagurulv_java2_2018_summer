package lv.javaguru.java2.serviceTests;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.dto.RegisterUserResponse;
import lv.javaguru.java2.validator.RegisterUserValidator;
import lv.javaguru.java2.validator.RegisterUserValidatorImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RegisterUserValidatorImplTest {

    private Database database;
    private RegisterUserValidator validator;

    @Before
    public void init() {
        database = Mockito.mock(Database.class);
        validator = new RegisterUserValidatorImpl(database);
    }

    @Test
    public void shouldReturnErrorsWhenLoginPasswordAndPhoneNull() {

        User user = new User();

        user.setFirstName("Vasja");
        user.setLastName("Pupkin");
        user.setEmail("vasja@pupkin.com");
        user.setDriver(false);

        List<Error> errors = validator.validate(user);

        assertEquals(3, errors.size());
        assertEquals("login", errors.get(0).getField() );
        assertEquals("Cannot be empty", errors.get(0).getDescription());

        assertEquals("password", errors.get(1).getField() );
        assertEquals("Cannot be empty", errors.get(1).getDescription());

        assertEquals("phone", errors.get(2).getField() );
        assertEquals("Cannot be empty", errors.get(2).getDescription());

    }

    @Test
    public void shouldReturnErrorsWhenLoginExists() {

        User existingFromDb = new User();
        existingFromDb.setLogin("test");

        Mockito.when(database.getUserByLogin("test"))
                .thenReturn(Optional.of(existingFromDb));

        User newUser = new User();
        newUser.setLogin("test");
        newUser.setPassword("pass");
        newUser.setPhone("123456789");
        List<Error> errors = validator.validate(newUser);

        assertEquals(1, errors.size());
        assertEquals("login", errors.get(0).getField() );
        assertEquals("Login already exist", errors.get(0).getDescription());
    }

}
