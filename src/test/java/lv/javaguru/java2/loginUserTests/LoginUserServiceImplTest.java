package lv.javaguru.java2.loginUserTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.user.login.LoginUserRequest;
import lv.javaguru.java2.buisnesslogic.user.login.LoginUserServiceImpl;
import lv.javaguru.java2.buisnesslogic.user.login.LoginUserValidator;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserServiceImpl;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserValidator;
import lv.javaguru.java2.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LoginUserServiceImplTest {

    @Mock
    private LoginUserValidator validator;

    @InjectMocks
    private LoginUserServiceImpl service = new LoginUserServiceImpl();

    @Test
    public void shouldReturnFailedResponseWhenValidationErrorsExist() {

        ApplicationError error = new ApplicationError( "login", "Cannot be empty" );

        List<ApplicationError> errors = new ArrayList<>(  );
        errors.add( error );

        User user = new User();
        LoginUserRequest request = new LoginUserRequest(user);

        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        try {
            service.login(request);
        }catch (ApplicationException e){
            Assert.assertEquals("Cannot be empty", e.getErrors().get( 0 ).getDescription() );
            Assert.assertEquals("login", e.getErrors().get( 0 ).getField() );

        }


    }


}
