package lv.javaguru.java2.web.dtos;

import lv.javaguru.java2.buisnesslogic.ApplicationError;

import java.util.List;

public class ApplicationExceptionDTO {

    private List<ApplicationError> errors;

    public ApplicationExceptionDTO() {
    }

    public ApplicationExceptionDTO(List<ApplicationError> errors) {
        this.errors = errors;
    }

    public List<ApplicationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ApplicationError> errors) {
        this.errors = errors;
    }
}
