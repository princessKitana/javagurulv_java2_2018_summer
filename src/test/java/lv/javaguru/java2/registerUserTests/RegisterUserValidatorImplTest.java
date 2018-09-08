package lv.javaguru.java2.registerUserTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.Error;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserValidator;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserValidatorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RegisterUserValidatorImplTest {
    @Mock
    private UserRepository database;

    @InjectMocks
    private RegisterUserValidator validator = new RegisterUserValidatorImpl();

    @Test
    public void shouldReturnErrorsWhenLoginPasswordAndPhoneNull() {

        User user = new User();

        user.setFirstName("Vasja");
        user.setLastName("Pupkin");

        RegisterUserRequest req = new RegisterUserRequest(user);
        List<ApplicationError> errors = validator.validate(req);

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
        existingFromDb.setPassword("secret");
        existingFromDb.setPhone("123456789");

        Mockito.when(database.getUserByLogin("test"))
                .thenReturn(Optional.of(existingFromDb));

        User user = new User();
        user.setLogin("test");
        user.setPassword("secret");
        user.setPhone("123456789");

        RegisterUserRequest req = new RegisterUserRequest(user);
        List<ApplicationError> errors = validator.validate(req);

        assertEquals(1, errors.size());
        assertEquals("login", errors.get(0).getField() );
        assertEquals("Already exist", errors.get(0).getDescription());
    }


    @Test
    public void shouldReturnErrorWhenEmailInvalid() {

        User newUser = new User();
        newUser.setLogin("pasha");
        newUser.setPassword("pass");
        newUser.setPhone("123456789");
        newUser.setEmail("hhh@mmm");

        RegisterUserRequest req = new RegisterUserRequest(newUser);
        List<ApplicationError> errors = validator.validate(req);

        assertEquals(1, errors.size());
        assertEquals("email", errors.get(0).getField() );
        assertEquals("Invalid format", errors.get(0).getDescription());
    }

}
