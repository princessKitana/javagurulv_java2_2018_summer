package lv.javaguru.java2.buisnesslogic.addtrip;

import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TripValidatorImpl implements TripValidator {

    //@Autowired
    //private TripRepository tripRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Error> validate(AddTripRequest request){
        List<Error> errors = new ArrayList<>();

        checkOriginNotBlank(request.getOrigin()).ifPresent(errors::add);
        checkDestinationNotBlank(request.getDestination()).ifPresent(errors::add);
        checkPriceValid(request.getPrice()).ifPresent(errors::add);
        checkDateValid(request.getDate()).ifPresent(errors::add);
        checkDriverExist(request.getDriverId());
        //TODO passanger count validation
        //TODO vehicle validation - vehicle exist and belongs to driver
        //TODO check time valid

        return errors;
    }

    private Optional<Error> checkOriginNotBlank(String origin) {

        if (origin == null || origin.isEmpty()) {
            return Optional.of(new Error("origin", "Cannot be empty"));
        }else
            return Optional.empty();
    }

    private Optional<Error> checkDestinationNotBlank(String destination) {

        if (destination == null || destination.isEmpty()) {
            return Optional.of(new Error("destination", "Cannot be empty"));
        }else
            return Optional.empty();
    }

    private Optional<Error> checkPriceValid(Double price) {

        try {
            if (price < 0 || price > 100)
                return Optional.of(new Error("price", "Must be from 0.00 to 100.00"));
        }catch (Exception e) {
            return Optional.of(new Error("price", "Not valid"));
        }

        return Optional.empty();
    }

    private  Optional<Error> checkDateValid(Date date) {

        long time = System.currentTimeMillis();
        Date systemDate = new Date(time);

        try {
            if (date == null) {
                return Optional.of(new Error("date", "Date must be filled"));
            }else {
                if (date.before(systemDate)) {
                    return Optional.of(new Error("date", "Date must be in future"));
                }
            }
        } catch (Exception ex) {
            return Optional.of(new Error("date", "Date not valid"));
        }
        return Optional.empty();
    }

    private Optional<Error>  checkDriverExist(Long driverId) {

        if (! userRepository.checkUserExist(driverId)) {
            return Optional.of(new Error("driverId", "Driver not found"));
        }else
            return Optional.empty();
    }

}
