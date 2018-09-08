package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    //List<Trip> getAllTrips(User user);

    void registerUser(User user);

    Optional<User> getUserByLogin(String login);

    Optional<User> getUserById(Long id);

    boolean checkUserExist(Long id);
}
