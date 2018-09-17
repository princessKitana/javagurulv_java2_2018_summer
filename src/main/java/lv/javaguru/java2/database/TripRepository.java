package lv.javaguru.java2.database;

import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.domain.Trip;

import java.util.List;
import java.util.Optional;

public interface TripRepository {

    //boolean cancel(Trip trip);

    List getAllTrips();

    void addTrip(Trip trip);

    boolean checkTripExist(Long id, TripStatus status);

    Optional<Trip> getTripById(Long id);
}
