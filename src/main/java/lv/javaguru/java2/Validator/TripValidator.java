package lv.javaguru.java2.Validator;

import lv.javaguru.java2.DTO.Error;
import lv.javaguru.java2.Domain.Trip;

import java.util.List;

public interface TripValidator{
    List<Error> validate(Trip trip);
}
