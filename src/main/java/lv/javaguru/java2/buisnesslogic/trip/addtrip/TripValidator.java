package lv.javaguru.java2.buisnesslogic.trip.addtrip;

import lv.javaguru.java2.buisnesslogic.ApplicationError;

import java.util.List;

public interface TripValidator{
    List<ApplicationError> validate(AddTripRequest request);
}
