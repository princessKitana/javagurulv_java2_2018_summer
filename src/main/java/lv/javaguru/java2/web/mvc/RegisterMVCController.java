package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserResponse;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserService;
import lv.javaguru.java2.database.ORM.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RegisterMVCController implements MVCController{

    @Autowired
    RegisterUserService registerUserService;

    @Override
    public MVCModel processPost(HttpServletRequest request) {

        RegisterUserRequest req = new RegisterUserRequest();
        req.setFirstName( request.getParameter( "first_name" ) );
        req.setLastName( request.getParameter( "last_name" ) );
        req.setLogin( request.getParameter( "username" ) );
        req.setPassword( request.getParameter( "password" ) );

        RegisterUserResponse res;
        try {
            res = registerUserService.registerUser( req );
        } catch (ApplicationException e) {
            return new MVCModel( "/register.jsp", e.getErrors() );
        }

        return new MVCModel( "/register.jsp", res );

    }

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        return new MVCModel("/register.jsp", null);
    }

}
