package lv.javaguru.java2.validator;

import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TripValidatorImpl implements TripValidator{
    @Autowired
    private Database database;

    @Override
    public List<Error> validate(Trip trip){
        List<Error> errors = new ArrayList<>();

        checkOriginNotBlank(trip.getOrigin(), errors);
        checkDestinationNotBlank(trip.getDestination(), errors);
        checkPriceValid(trip.getPrice(), errors);
        checkDateValid(trip.getDate(), errors);
        checkTimeValid(trip.getTime(), errors);

        //TODO: checkTripDuplicates(trip, errors);

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

        if (price == null || price.isNaN()|| price<0 || price >100 ) {
            Error error = new Error("price", "Must be from 0.00 to 100.00");
            errors.add(error);
        }
    }

    private void checkDateValid(Date date, List<Error> errors) {

        //TODO add calendar day validation
        long time = System.currentTimeMillis();
        Date systemDate = new Date(time);
        if (date == null || date.before(systemDate)) {
            Error error = new Error("date", "Date must be set in future");
            errors.add(error);
        }
    }

    private void checkTimeValid(LocalTime time, List<Error> errors) {

        LocalTime time1 = LocalTime.of(0, 0);
        LocalTime time2 = LocalTime.of(23, 59);

        if (time == null || time.isBefore(time1) || time.isAfter(time2)) {
            Error error = new Error("time", "Must be from 0.00 till 23.59");
            errors.add(error);
        }
    }
}
