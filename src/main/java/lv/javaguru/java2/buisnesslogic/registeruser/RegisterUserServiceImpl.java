package lv.javaguru.java2.buisnesslogic.registeruser;

import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    private RegisterUserValidator validator;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public RegisterUserResponse registerUser(RegisterUserRequest request){

        List<Error> validationErrors = validator.validate(request);

        if (!validationErrors.isEmpty()) {
            return new RegisterUserResponse(validationErrors);
        }

        // create new user
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());

        // store to db
        userRepository.registerUser(user);

        return new RegisterUserResponse(user.getId());

    }
}
