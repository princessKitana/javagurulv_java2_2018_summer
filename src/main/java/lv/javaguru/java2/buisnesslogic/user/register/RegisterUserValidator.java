package lv.javaguru.java2.buisnesslogic.user.register;

import lv.javaguru.java2.buisnesslogic.ApplicationError;

import java.util.List;

public interface RegisterUserValidator {
    List<ApplicationError> validate(RegisterUserRequest request);
}
