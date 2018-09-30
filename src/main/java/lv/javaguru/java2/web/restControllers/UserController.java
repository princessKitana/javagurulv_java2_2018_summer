package lv.javaguru.java2.web.restControllers;

import lv.javaguru.java2.buisnesslogic.user.get.GetUserRequest;
import lv.javaguru.java2.buisnesslogic.user.get.GetUserResponse;
import lv.javaguru.java2.buisnesslogic.user.get.GetUserService;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserRequest;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserResponse;
import lv.javaguru.java2.buisnesslogic.user.register.RegisterUserService;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.web.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private RegisterUserService userRegistrationService;

    @Autowired
    private GetUserService getUserService;

    @ResponseBody
    @PostMapping(value = "/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {

        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());

        RegisterUserRequest request = new RegisterUserRequest(user);

        RegisterUserResponse response = userRegistrationService.registerUser(request);
        userDTO.setId(response.getUserId());
        return ResponseEntity.ok(userDTO);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") Long userId) {
        GetUserRequest request = new GetUserRequest(userId);
        GetUserResponse response = getUserService.get(request);
        return response.getUser();
    }

}
