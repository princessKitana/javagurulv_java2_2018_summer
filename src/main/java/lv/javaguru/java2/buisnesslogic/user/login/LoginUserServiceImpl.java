package lv.javaguru.java2.buisnesslogic.user.login;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserResponse;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserService;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserValidator;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private LoginUserValidator validator;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public LoginUserResponse login(LoginUserRequest request){

        List<ApplicationError> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            throw new ApplicationException(validationErrors);
        }

        Optional <User> user = userRepository.getUserByLogin(request.getLogin());

        return new LoginUserResponse(user.get().getId());

    }
}
