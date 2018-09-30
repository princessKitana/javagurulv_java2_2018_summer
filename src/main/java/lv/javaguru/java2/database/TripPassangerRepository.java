package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.TripPassanger;

import java.util.Optional;

public interface TripPassangerRepository {

    void addTripPassanger(TripPassanger tripPassanger);

    Optional<TripPassanger> checkPassangerAppliedForTrip(Long id, Long tripId);
}
