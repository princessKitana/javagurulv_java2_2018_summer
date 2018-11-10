package lv.javaguru.java2.buisnesslogic.user.login;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserValidator;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class LoginUserValidatorImpl implements LoginUserValidator {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<ApplicationError> validate(LoginUserRequest request){

        List<ApplicationError> errors = new ArrayList<>();

        validateLogin(request.getLogin()).ifPresent(errors::add);
        validatePassword(request.getPassword()).ifPresent(errors::add);
        validatePasswordMatch(request.getLogin(), request.getPassword()).ifPresent(errors::add);
        return errors;
    }

    private Optional<ApplicationError> validateLogin(String login) {
        if (login == null || login.isEmpty()) {
            return Optional.of(new ApplicationError("login", "Cannot be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<ApplicationError> validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return Optional.of(new ApplicationError("password", "Cannot be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<ApplicationError> validatePasswordMatch(String login, String password) {

        Optional<User> user = userRepository.getUserByLogin(login);

        if (user.isPresent()){
            if (user.get().getPassword().equals(password) ){
                return Optional.empty();
            }else
                return Optional.of(new ApplicationError("password", "Do not match"));
        }else
            return Optional.of(new ApplicationError("login", "Not found"));

    }
}

