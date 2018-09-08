package lv.javaguru.java2.buisnesslogic.user.register;

import lv.javaguru.java2.Error;

import java.util.List;

public class RegisterUserResponse {

    private boolean success;
    private Long userId;
    private List<Error> errors;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }


    public boolean isSuccess() {
        return success;
    }


    public RegisterUserResponse(Long userId) {
        this.success = true;
        this.userId = userId;
    }

    public RegisterUserResponse(List<Error> errors) {
        this.success = false;
        this.errors = errors;
    }
}
