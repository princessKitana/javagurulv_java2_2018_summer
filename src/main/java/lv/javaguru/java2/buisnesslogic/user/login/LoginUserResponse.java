package lv.javaguru.java2.buisnesslogic.user.login;

import lv.javaguru.java2.buisnesslogic.ApplicationError;

import java.util.List;

public class LoginUserResponse {

    private boolean success;
    private Long userId;
    private List<ApplicationError> applicationErrors;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ApplicationError> getApplicationErrors() {
        return applicationErrors;
    }

    public void setApplicationErrors(List<ApplicationError> applicationErrors) {
        this.applicationErrors = applicationErrors;
    }


    public boolean isSuccess() {
        return success;
    }


    public LoginUserResponse(Long userId) {
        this.success = true;
        this.userId = userId;
    }

    public LoginUserResponse(List<ApplicationError> applicationErrors) {
        this.success = false;
        this.applicationErrors = applicationErrors;
    }
}
