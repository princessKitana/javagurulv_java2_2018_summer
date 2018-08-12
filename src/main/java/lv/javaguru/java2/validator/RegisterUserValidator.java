package lv.javaguru.java2.validator;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.Error;

import java.util.List;

public interface RegisterUserValidator {
    List<Error> validate(User user);
}
