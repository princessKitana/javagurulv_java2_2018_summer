package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Trip;

import java.util.List;

public interface TripRepository {

    //boolean cancel(Trip trip);

    List getAllTrips();

    void addTrip(Trip trip);
}
