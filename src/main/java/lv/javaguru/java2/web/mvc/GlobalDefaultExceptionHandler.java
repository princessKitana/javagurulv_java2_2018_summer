package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "errors";

    @ExceptionHandler(value = {ApplicationException.class})
    public ModelAndView defaultErrorHandler(ApplicationException ex,
                                            HttpServletRequest request) {

        //send the user to a default error-view
        ModelAndView mav = new ModelAndView();
        ApplicationExceptionDTO appExDTO = new ApplicationExceptionDTO(ex.getErrors());
        mav.addObject("exception", appExDTO);
        mav.addObject("url", request.getRequestURI());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

}
