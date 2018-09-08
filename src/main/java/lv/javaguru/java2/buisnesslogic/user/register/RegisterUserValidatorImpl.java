package lv.javaguru.java2.buisnesslogic.user.register;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
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
    public List<ApplicationError> validate(RegisterUserRequest request){

        List<ApplicationError> errors = new ArrayList<>();

        validateLogin(request.getLogin()).ifPresent(errors::add);
        validatePassword(request.getPassword()).ifPresent(errors::add);
        validatePhone(request.getPhone()).ifPresent(errors::add);
        validateEmail(request.getEmail()).ifPresent(errors::add);
        validateDuplicateLogin(request.getLogin()).ifPresent(errors::add);

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

    private Optional<ApplicationError> validatePhone(String phone){

        if (phone == null || phone.isEmpty()) {
            ApplicationError error = new ApplicationError("phone", "Cannot be empty");
            return Optional.of(error);
        }else
            return Optional.empty();
    }


    private Optional<ApplicationError> validateDuplicateLogin(String login){
        if (login != null && !login.isEmpty()) {

            Optional<User> user = userRepository.getUserByLogin(login);

            if (user.isPresent()) {
                ApplicationError error = new ApplicationError("login", "Already exist");
                return Optional.of(error);
            } else
                return Optional.empty();

        }else {
            return Optional.empty();
        }
    }

    private Optional<ApplicationError> validateEmail(String email){

        //email is not mandatory
        if (email == null || email.isEmpty())
            return Optional.empty();
        else {
            String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (!matcher.matches()) {
                ApplicationError error = new ApplicationError("email", "Invalid format");
                return Optional.of(error);
            } else
                return Optional.empty();
        }
    }

}

