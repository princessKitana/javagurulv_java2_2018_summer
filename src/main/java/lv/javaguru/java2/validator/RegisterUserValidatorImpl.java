package lv.javaguru.java2.validator;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.database.JDBCDatabaseImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RegisterUserValidatorImpl implements RegisterUserValidator {

    private Database database;

    public RegisterUserValidatorImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Error> validate(User user){

            List<Error> errors = new ArrayList<>();

            if (!checkLoginIsBlank(user.getLogin(), errors)){
                checkLoginNotExist(user.getLogin(), errors);
            }

            checkPasswordNotBlank(user.getPassword(), errors);
            checkPhoneNotBlank(user.getPhone(), errors);


            return errors;
        }

        private boolean checkLoginIsBlank(String login, List<Error> errors){

            if (login == null || login.isEmpty()) {
                Error error = new Error("login", "Cannot be empty");
                errors.add(error);
                return true;
            }else return false;
        }

    private void checkPasswordNotBlank(String password, List<Error> errors){

        if (password == null || password.isEmpty()) {
            Error error = new Error("password", "Cannot be empty");
            errors.add(error);
        }
    }

    private void checkPhoneNotBlank(String phone, List<Error> errors){

        if (phone == null || phone.isEmpty()) {
            Error error = new Error("phone", "Cannot be empty");
            errors.add(error);
        }
    }

    private void checkLoginNotExist(String login, List<Error> errors){
        Optional<User> user = database.getUserByLogin(login);

        if (user.isPresent()){
            Error error = new Error("login", "Login already exist");
            errors.add(error);
        }
    }


}

