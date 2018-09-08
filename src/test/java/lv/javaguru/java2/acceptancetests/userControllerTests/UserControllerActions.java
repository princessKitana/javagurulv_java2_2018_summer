package lv.javaguru.java2.acceptancetests.userControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import lv.javaguru.java2.web.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Random;

public class UserControllerActions {

    private static final String BASE_URL = "http://localhost:8080/java2/user";

    private RestTemplate restTemplate = new RestTemplate();

    public UserDTO createRandomUser() {
        UserDTO user = new UserDTO();
        user.setId(null);
        user.setLogin(generateRandomString("login", 10000000));
        user.setPassword(generateRandomString("password", 10000000));
        user.setPhone("+371 2589712596");
        user.setFirstName("Pasha");
        user.setLastName("Vtoroj");
        user.setEmail(user.getLogin() + "@mailinator.com");

        return user;
    }

    public UserDTO createUser(UserDTO user) {

        ResponseEntity<UserDTO> response =
                restTemplate.postForEntity(
                        BASE_URL,
                        user,
                        UserDTO.class);

        return response.getBody();
    }

    public UserDTO getUser(Long userId) {
        ResponseEntity<UserDTO> response =
                restTemplate.getForEntity(
                        BASE_URL + "/" + userId, UserDTO.class);
        return response.getBody();
    }

    public ResponseEntity<ApplicationExceptionDTO> createUserWithException(UserDTO user) {

        try {
            restTemplate.postForEntity(
                    BASE_URL,
                    user,
                    ApplicationExceptionDTO.class);
        } catch (HttpClientErrorException e) {
            String responseBody = e.getResponseBodyAsString();
            return ResponseEntity
                    .status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(convertToAppException(responseBody));
        }
        throw new RuntimeException("Create user not failed with exception but should be!");
    }

    private ApplicationExceptionDTO convertToAppException(String response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response, ApplicationExceptionDTO.class);
        } catch (IOException e) {
            throw new RuntimeException("JSON parsing exception", e);
        }
    }

    private String generateRandomString(String prefix, int bound) {
        Random random = new Random();
        return prefix + random.nextInt(bound);
    }

}
