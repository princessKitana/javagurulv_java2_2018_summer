package lv.javaguru.java2.registerUserTests;

import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserRequest;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.Error;
import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserResponse;
import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserServiceImpl;
import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserValidator;
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
public class RegisterUserServiceImplTest {

    @Mock
    private RegisterUserValidator validator;

    @InjectMocks
    private RegisterUserServiceImpl service = new RegisterUserServiceImpl();

    @Test
    public void shouldReturnFailedResponseWhenValidationErrorsExist() {


        List<Error> errors = Collections.singletonList(
                new Error("login", "Cannot be empty")
        );

        User user = new User();
        RegisterUserRequest request = new RegisterUserRequest(user);

        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        RegisterUserResponse response = service.registerUser(request);

        assertFalse(response.isSuccess());
    }


}
