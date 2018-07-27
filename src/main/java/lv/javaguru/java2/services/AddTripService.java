package lv.javaguru.java2.services;

import lv.javaguru.java2.DTO.AddProductResponse;
import lv.javaguru.java2.DTO.AddTripResponse;
import lv.javaguru.java2.DTO.Error;
import lv.javaguru.java2.Domain.Product;
import lv.javaguru.java2.Domain.Trip;
import lv.javaguru.java2.Validator.ProductValidator;
import lv.javaguru.java2.database.Database;

import java.sql.Date;
import java.util.List;

public class AddTripService {
    private Database database;
    private ProductValidator validator;

    public AddTripService(ProductValidator validator,
                             Database database) {
        this.validator = validator;
        this.database = database;
    }

    public AddTripResponse addTrip(Trip trip){
        //TODO add validation
        //List<Error> validationErrors = validator.validate(title, description);

        //if (!validationErrors.isEmpty()) {
            //return new AddProductResponse(validationErrors);
        //}

        database.addTrip(trip);

        return new AddTripResponse(trip.getId());
    }
}
