package lv.javaguru.java2.buisnesslogic.trip.applyForTrip;

import lv.javaguru.java2.buisnesslogic.ApplicationError;

import java.util.List;

public interface ApplyForTripValidator {
    List<ApplicationError> validate(ApplyForTripRequest request);
}
