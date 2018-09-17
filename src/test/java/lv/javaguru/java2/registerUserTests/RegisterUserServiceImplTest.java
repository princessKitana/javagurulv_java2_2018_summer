package lv.javaguru.java2.registerUserTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserResponse;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserServiceImpl;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
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

        ApplicationError error = new ApplicationError( "login", "Cannot be empty" );

        List<ApplicationError> errors = new ArrayList<>(  );
        errors.add( error );

        User user = new User();
        RegisterUserRequest request = new RegisterUserRequest(user);

        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        try {
            service.registerUser(request);
        }catch (ApplicationException e){
            Assert.assertEquals("Cannot be empty", e.getErrors().get( 0 ).getDescription() );
            Assert.assertEquals("login", e.getErrors().get( 0 ).getField() );

        }


    }


}
