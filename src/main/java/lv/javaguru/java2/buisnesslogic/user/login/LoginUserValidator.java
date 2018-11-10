package lv.javaguru.java2.buisnesslogic.user.login;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;

import java.util.List;

public interface LoginUserValidator {
    List<ApplicationError> validate(LoginUserRequest request);
}
