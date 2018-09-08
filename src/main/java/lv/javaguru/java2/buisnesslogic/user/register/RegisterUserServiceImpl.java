package lv.javaguru.java2.buisnesslogic.user.register;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.user.get.GetUserResponse;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.Error;
import lv.javaguru.java2.web.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    private RegisterUserValidator validator;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public RegisterUserResponse registerUser(RegisterUserRequest request){

        List<ApplicationError> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            throw new ApplicationException(validationErrors);
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
