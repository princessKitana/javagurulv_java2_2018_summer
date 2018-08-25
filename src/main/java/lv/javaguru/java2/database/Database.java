package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.TripPassanger;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface Database {


   // boolean remove(Product product);

    List<Trip> getAllTrips();

    void addTrip(Trip trip);

    void registerUser(User user);

    Optional<User> getUserByLogin(String login);

    boolean checkUserExist(Long id);

    void addVehicle(Vehicle car);

    void addTripPassanger(TripPassanger tripPassanger);
}
