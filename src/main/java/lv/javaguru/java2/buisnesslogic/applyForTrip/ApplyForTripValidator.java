package lv.javaguru.java2.buisnesslogic.applyForTrip;

import lv.javaguru.java2.Error;

import java.util.List;

public interface ApplyForTripValidator {
    List<Error> validate(ApplyForTripRequest request);
}
