package lv.javaguru.java2.serviceTests;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.AddTripResponse;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.dto.RegisterUserResponse;
import lv.javaguru.java2.services.RegisterUserService;
import lv.javaguru.java2.validator.RegisterUserValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class RegisterUserServiceTest {

    @Mock
    private RegisterUserValidator validator;

    @InjectMocks
    private RegisterUserService service = new RegisterUserService();

    @Test
    public void shouldReturnFailedResponseWhenValidationErrorsExist() {
        User user = new User();

        List<Error> errors = Collections.singletonList(
                new Error("login", "Cannot be empty")
        );


        Mockito.when(validator.validate(user))
                .thenReturn(errors);

        RegisterUserResponse response = service.registerUser(user);

        assertFalse(response.isSuccess());
    }


}
