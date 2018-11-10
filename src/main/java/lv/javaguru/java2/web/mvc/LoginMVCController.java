package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.user.login.LoginUserRequest;
import lv.javaguru.java2.buisnesslogic.user.login.LoginUserResponse;
import lv.javaguru.java2.buisnesslogic.user.login.LoginUserService;
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginMVCController {


    @Autowired
    LoginUserService loginUserService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("userDTO", new UserDTO());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") UserDTO userDTO) {
        ModelAndView mav = null;

        LoginUserRequest loginUserRequest = new LoginUserRequest(  );
        loginUserRequest.setLogin( userDTO.getLogin() );
        loginUserRequest.setPassword( userDTO.getPassword() );
        LoginUserResponse loginUserResponse = loginUserService.login(loginUserRequest);

        if (loginUserResponse.isSuccess()) {
            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("userId", loginUserResponse.getUserId()); //setting session attribute
            session.setMaxInactiveInterval(60*3);
            mav = new ModelAndView("index");

        }else
            mav = new ModelAndView("errors");

        return mav;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        ModelAndView mav = new ModelAndView("welcome");
        return mav;
    }
}
