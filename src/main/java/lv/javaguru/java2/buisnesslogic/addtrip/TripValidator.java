package lv.javaguru.java2.buisnesslogic.addtrip;

import lv.javaguru.java2.Error;

import java.util.List;

public interface TripValidator{
    List<Error> validate(AddTripRequest request);
}
