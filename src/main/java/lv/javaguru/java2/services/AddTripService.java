package lv.javaguru.java2.services;

import lv.javaguru.java2.DTO.AddProductResponse;
import lv.javaguru.java2.DTO.AddTripResponse;
import lv.javaguru.java2.DTO.Error;
import lv.javaguru.java2.Domain.Product;
import lv.javaguru.java2.Domain.Trip;
import lv.javaguru.java2.Validator.ProductValidator;
import lv.javaguru.java2.Validator.TripValidator;
import lv.javaguru.java2.database.Database;

import java.sql.Date;
import java.util.List;

public class AddTripService {
    private Database database;
    private TripValidator validator;

    public AddTripService(TripValidator validator,
                             Database database) {
        this.validator = validator;
        this.database = database;
    }

    public AddTripResponse addTrip(Trip trip){

        List<Error> validationErrors = validator.validate(trip);

        if (!validationErrors.isEmpty()) {
            return new AddTripResponse(validationErrors);
        }

        database.addTrip(trip);

        return new AddTripResponse(trip.getId());
    }
}
