package lv.javaguru.java2.buisnesslogic.user.get;

import lv.javaguru.java2.web.dtos.UserDTO;

public class GetUserResponse {

    private UserDTO user;

    public GetUserResponse(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
