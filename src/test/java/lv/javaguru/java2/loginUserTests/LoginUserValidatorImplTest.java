package lv.javaguru.java2.loginUserTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.user.login.LoginUserRequest;
import lv.javaguru.java2.buisnesslogic.user.login.LoginUserValidator;
import lv.javaguru.java2.buisnesslogic.user.login.LoginUserValidatorImpl;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserValidator;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserValidatorImpl;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
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
public class LoginUserValidatorImplTest {
    @Mock
    private UserRepository database;

    @InjectMocks
    private LoginUserValidator validator = new LoginUserValidatorImpl();

    @Test
    public void shouldReturnErrorsWhenLoginPasswordNull() {

        User user = new User();

        LoginUserRequest req = new LoginUserRequest(user);
        List<ApplicationError> errors = validator.validate(req);

        assertEquals(3, errors.size());
        assertEquals("login", errors.get(0).getField() );
        assertEquals("Cannot be empty", errors.get(0).getDescription());

        assertEquals("password", errors.get(1).getField() );
        assertEquals("Cannot be empty", errors.get(1).getDescription());

        assertEquals("login", errors.get(2).getField() );
        assertEquals("Not found", errors.get(2).getDescription());
    }

    @Test
    public void shouldReturnErrorsWhenUserWithLoginNotFound() {

        Mockito.when(database.getUserByLogin("otherLogin"))
                .thenReturn(Optional.empty());

        User user = new User();
        user.setLogin("otherLogin");
        user.setPassword("secret");

        LoginUserRequest req = new LoginUserRequest(user);
        List<ApplicationError> errors = validator.validate(req);

        assertEquals(1, errors.size());
        assertEquals("login", errors.get(0).getField() );
        assertEquals("Not found", errors.get(0).getDescription());
    }

    @Test
    public void shouldReturnErrorWhenPasswordDoNotMatch() {

        User existingFromDb = new User();
        existingFromDb.setLogin("test");
        existingFromDb.setPassword("secret");

        Mockito.when(database.getUserByLogin("test"))
                .thenReturn(Optional.of(existingFromDb));

        User user = new User();
        user.setLogin("test");
        user.setPassword("secretOther");

        LoginUserRequest req = new LoginUserRequest(user);
        List<ApplicationError> errors = validator.validate(req);

        assertEquals(1, errors.size());
        assertEquals("password", errors.get(0).getField() );
        assertEquals("Do not match", errors.get(0).getDescription());
    }

}
