package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserResponse;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserService;
import lv.javaguru.java2.web.dtos.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserMVCController {


    @Autowired
    RegisterUserService registerUserService;

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView registerUser(HttpServletRequest request,
                                     HttpServletResponse response,
                                     @ModelAttribute("user") UserDTO user) {

        RegisterUserRequest req = new RegisterUserRequest();
        req.setFirstName( request.getParameter( "firstname" ) );
        req.setLastName( request.getParameter( "lastname" ) );
        req.setEmail( request.getParameter( "email" ) );
        req.setPhone( request.getParameter( "phone" ) );
        req.setLogin( request.getParameter( "login" ) );
        req.setPassword( request.getParameter( "password" ) );

        RegisterUserResponse res= registerUserService.registerUser( req );

        return new ModelAndView("index", "welcome", res);
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegisterUserForm(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new UserDTO(  ));
        return mav;
    }





}
