package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "errors";

    @ExceptionHandler(value = {ApplicationException.class})
    protected ResponseEntity<Object> handleApplicationException(ApplicationException ex,
                                                                WebRequest request) {
        ApplicationExceptionDTO appExDTO = new ApplicationExceptionDTO(ex.getErrors());
        return handleExceptionInternal(ex, appExDTO,
                new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

//    @ExceptionHandler(value = {ApplicationException.class})
//    public ModelAndView defaultErrorHandler(ApplicationException ex,
//                                            HttpServletRequest request) throws Exception {
////HttpServletRequest req, Exception e
//
//        //send the user to a default error-view
//        ModelAndView mav = new ModelAndView();
//        ApplicationExceptionDTO appExDTO = new ApplicationExceptionDTO(ex.getErrors());
//        mav.addObject("exception", appExDTO);
//        mav.addObject("url", request.getRequestURI());
//        mav.setViewName(DEFAULT_ERROR_VIEW);
//        return mav;
//    }

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleRuntimeException(ApplicationException ex,
                                                            WebRequest request) {
        return handleExceptionInternal(ex, ex,
                new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }
}
