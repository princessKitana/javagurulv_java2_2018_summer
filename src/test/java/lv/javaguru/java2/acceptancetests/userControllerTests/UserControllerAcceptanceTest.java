package lv.javaguru.java2.acceptancetests.userControllerTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import lv.javaguru.java2.web.dtos.UserDTO;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserControllerAcceptanceTest {

    private UserControllerActions actions = new UserControllerActions();

    @Test
    public void createUser() {
        UserDTO userReq = actions.createRandomUser();
        UserDTO userResp = actions.createUser(userReq);
        assertTrue(userResp.getId() != null);
        assertTrue(userResp.getLogin().equals(userReq.getLogin()));
        assertTrue(userResp.getPassword().equals(userReq.getPassword()));
    }

    @Test
    public void getUser() {
        UserDTO userReq = actions.createRandomUser();
        UserDTO userResp = actions.createUser(userReq);

        UserDTO user = actions.getUser(userResp.getId());
        assertTrue(Objects.equals(user.getId(), userResp.getId()));
        assertTrue(Objects.equals(user.getLogin(), userResp.getLogin()));
        assertTrue(Objects.equals(user.getPassword(), userResp.getPassword()));
    }

    @Test
    public void createUserWithSameLogin() {
        UserDTO user = actions.createRandomUser();
        actions.createUser(user);

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.createUserWithException(user);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "login", errors.get(0).getField());
        assertEquals("Already exist", errors.get(0).getDescription());
    }

    @Test
    public void createUserWithEmptyLogin() {
        UserDTO user = actions.createRandomUser();
        user.setLogin("");

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.createUserWithException(user);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(errors.size(), 1);
        assertEquals("login", errors.get(0).getField()) ;
        assertEquals("Cannot be empty", errors.get(0).getDescription() );
    }

    @Test
    public void createUserWithEmptyPassword() {
        UserDTO user = actions.createRandomUser();
        user.setPassword(null);

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.createUserWithException(user);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(errors.size(), 1);
        assertEquals("password", errors.get(0).getField()) ;
        assertEquals("Cannot be empty", errors.get(0).getDescription() );
    }

    @Test
    public void createUserWithEmptyPhone() {
        UserDTO user = actions.createRandomUser();
        user.setPhone(null);

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.createUserWithException(user);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(errors.size(), 1);
        assertEquals("phone", errors.get(0).getField()) ;
        assertEquals("Cannot be empty", errors.get(0).getDescription() );
    }


    @Test
    public void createUserWithInvalidEmail() {
        UserDTO user = actions.createRandomUser();
        user.setEmail("@jjjhhfdxcu");

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.createUserWithException(user);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(errors.size(), 1);
        assertEquals("email", errors.get(0).getField()) ;
        assertEquals("Invalid format", errors.get(0).getDescription() );
    }

}
