package lv.javaguru.java2.buisnesslogic.registeruser;

import lv.javaguru.java2.Error;

import java.util.List;

public interface RegisterUserValidator {
    List<Error> validate(RegisterUserRequest request);
}
