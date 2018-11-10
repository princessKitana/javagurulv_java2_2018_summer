package lv.javaguru.java2.buisnesslogic.user.login;

import lv.javaguru.java2.domain.User;

public class LoginUserRequest {

    private String login;
    private String password;

    public LoginUserRequest(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();;
    }

    public LoginUserRequest() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
