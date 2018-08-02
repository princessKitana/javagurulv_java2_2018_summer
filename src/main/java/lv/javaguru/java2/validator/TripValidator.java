package lv.javaguru.java2.validator;

import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.domain.Trip;

import java.util.List;

public interface TripValidator{
    List<Error> validate(Trip trip);
}
