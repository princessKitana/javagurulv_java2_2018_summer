package lv.javaguru.java2.web.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MainMVCController implements MVCController{

    public MVCModel processGet(HttpServletRequest request) {

        return new MVCModel("/main.jsp", "Main");

    }


    public MVCModel processPost(HttpServletRequest request) {

        throw new UnsupportedOperationException();


    }
}
