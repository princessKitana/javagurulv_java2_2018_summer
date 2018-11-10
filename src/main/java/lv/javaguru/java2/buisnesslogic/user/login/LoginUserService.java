package lv.javaguru.java2.buisnesslogic.user.login;

import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserResponse;

public interface LoginUserService {

    LoginUserResponse login(LoginUserRequest request);

}
