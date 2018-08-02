package lv.javaguru.java2.services;

import lv.javaguru.java2.dto.AddTripResponse;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.validator.TripValidator;
import lv.javaguru.java2.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddTripService {
    @Autowired
    private Database database;

    @Autowired
    private TripValidator validator;

    public AddTripResponse addTrip(Trip trip){

        List<Error> validationErrors = validator.validate(trip);

        if (!validationErrors.isEmpty()) {
            return new AddTripResponse(validationErrors);
        }

        database.addTrip(trip);

        return new AddTripResponse(trip.getId());
    }
}
