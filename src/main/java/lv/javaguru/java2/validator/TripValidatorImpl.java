package lv.javaguru.java2.validator;

import lv.javaguru.java2.database.JDBCDatabaseImpl;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class TripValidatorImpl implements TripValidator{

@Autowired
Database database = new JDBCDatabaseImpl();

    @Override
    public List<Error> validate(Trip trip){
        List<Error> errors = new ArrayList<>();

        checkOriginNotBlank(trip.getOrigin(), errors);
        checkDestinationNotBlank(trip.getDestination(), errors);
        checkPriceValid(trip.getPrice(), errors);
        checkDateValid(trip.getDate(), errors);
        checkDriverExist(trip.getDriverId(), errors);

        return errors;
    }

    private void checkOriginNotBlank(String origin, List<Error> errors) {

        if (origin == null || origin.isEmpty()) {
            Error error = new Error("origin", "Cannot be empty");
            errors.add(error);
        }
    }

    private void checkDestinationNotBlank(String destination, List<Error> errors) {

        if (destination == null || destination.isEmpty()) {
            Error error = new Error("destination", "Cannot be empty");
            errors.add(error);
        }
    }

    private void checkPriceValid(Double price, List<Error> errors) {

        try {
            if (price < 0 || price > 100) {
                Error error = new Error("price", "Must be from 0.00 to 100.00");
                errors.add(error);
            }
        } catch (Exception ex) {
            Error error = new Error("price", "Not valid");
            errors.add(error);
         }
    }

    private void checkDateValid(Date date, List<Error> errors) {

        long time = System.currentTimeMillis();
        Date systemDate = new Date(time);

        try {

            if (date == null) {
                Error error = new Error("date", "Date must be filled");
                errors.add(error);
                return;
            }else {
                if (date.before(systemDate)) {
                    Error error = new Error("date", "Date must be in future");
                    errors.add(error);
                }
            }
        } catch (Exception ex) {
            Error error = new Error("date", "Date not valid");

            errors.add(error);
        }
    }

    //TODO check time valid


    private void checkDriverExist(Long driverId, List<Error> errors) {

        if (! database.checkUserExist(driverId)) {

            Error error = new Error("driverId", "Driver not found");
            errors.add(error);
        }
    }

}
