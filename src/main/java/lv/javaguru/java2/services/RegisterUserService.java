package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.RegisterUserResponse;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.validator.RegisterUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserService {

    @Autowired
    private Database database;

    @Autowired
    private RegisterUserValidator validator;

    public RegisterUserResponse registerUser(User user){

        List<Error> validationErrors = validator.validate(user);

        if (!validationErrors.isEmpty()) {
            return new RegisterUserResponse(validationErrors);
        }

        database.registerUser(user);

        return new RegisterUserResponse(user.getId());
    }
}
