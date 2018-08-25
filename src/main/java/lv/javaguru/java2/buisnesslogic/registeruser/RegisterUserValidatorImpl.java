package lv.javaguru.java2.buisnesslogic.registeruser;

import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegisterUserValidatorImpl implements RegisterUserValidator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Error> validate(RegisterUserRequest request){

        List<Error> errors = new ArrayList<>();

        validateLogin(request.getLogin()).ifPresent(errors::add);
        validatePassword(request.getPassword()).ifPresent(errors::add);
        validatePhone(request.getPhone()).ifPresent(errors::add);
        validateEmail(request.getEmail()).ifPresent(errors::add);
        validateDuplicateLogin(request.getLogin()).ifPresent(errors::add);

        return errors;
    }


    private Optional<Error> validateLogin(String login) {
        if (login == null || login.isEmpty()) {
            return Optional.of(new Error("login", "Cannot be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return Optional.of(new Error("password", "Cannot be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validatePhone(String phone){

        if (phone == null || phone.isEmpty()) {
            Error error = new Error("phone", "Cannot be empty");
            return Optional.of(error);
        }else
            return Optional.empty();
    }


    private Optional<Error> validateDuplicateLogin(String login){
        if (login != null && !login.isEmpty()) {

            Optional<User> user = userRepository.getUserByLogin(login);

            if (user.isPresent()) {
                Error error = new Error("login", "Already exist");
                return Optional.of(error);
            } else
                return Optional.empty();

        }else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateEmail(String email){

        //email is not mandatory
        if (email == null || email.isEmpty())
            return Optional.empty();
        else {
            String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (!matcher.matches()) {
                Error error = new Error("email", "Invalid format");
                return Optional.of(error);
            } else
                return Optional.empty();
        }
    }

}

