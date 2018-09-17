package lv.javaguru.java2.web.servlets.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HelloWorldController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        return new MVCModel("/helloWorld.jsp", "My test data!");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }
}
