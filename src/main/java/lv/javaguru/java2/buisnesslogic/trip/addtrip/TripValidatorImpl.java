package lv.javaguru.java2.buisnesslogic.trip.addtrip;


import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.database.VehicleRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TripValidatorImpl implements TripValidator {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ApplicationError> validate(AddTripRequest request){
        List<ApplicationError> applicationErrors = new ArrayList<>();

        checkOriginNotBlank(request.getOrigin()).ifPresent(applicationErrors::add);
        checkDestinationNotBlank(request.getDestination()).ifPresent(applicationErrors::add);
        checkPriceValid(request.getPrice()).ifPresent(applicationErrors::add);
        //TODO DATE format validation
        checkDateValid(request.getDate()).ifPresent(applicationErrors::add);
        checkDriverExist(request.getDriverId()).ifPresent(applicationErrors::add);
        checkPassengerCount(request.getPassangerCount()).ifPresent(applicationErrors::add);
        checkVehicleExistsAndBelongsToDriver(request.getVehicleId(), request.getDriverId()).ifPresent(applicationErrors::add);
        checkTimeValid(request.getTime()).ifPresent(applicationErrors::add);

        return applicationErrors;
    }

    private Optional<ApplicationError> checkOriginNotBlank(String origin) {

        if (origin == null || origin.isEmpty()) {
            return Optional.of(new ApplicationError("origin", "Cannot be empty"));
        }else
            return Optional.empty();
    }

    private Optional<ApplicationError> checkDestinationNotBlank(String destination) {

        if (destination == null || destination.isEmpty()) {
            return Optional.of(new ApplicationError("destination", "Cannot be empty"));
        }else
            return Optional.empty();
    }

    private Optional<ApplicationError> checkPriceValid(Double price) {

        try {
            if (price < 0 || price > 100)
                return Optional.of(new ApplicationError("price", "Must be from 0.00 to 100.00"));
        }catch (Exception e) {
            return Optional.of(new ApplicationError("price", "Not valid"));
        }

        return Optional.empty();
    }

    private  Optional<ApplicationError> checkDateValid(Date date) {

        long time = System.currentTimeMillis();
        Date systemDate = new Date(time);

        try {
            if (date == null) {
                return Optional.of(new ApplicationError("date", "Date must be filled"));
            }else {
                if (date.before(systemDate)) {
                    return Optional.of(new ApplicationError("date", "Date must be in future"));
                }
            }
        } catch (Exception ex) {
            return Optional.of(new ApplicationError("date", "Date not valid"));
        }
        return Optional.empty();
    }

    private Optional<ApplicationError>  checkDriverExist(Long driverId) {
        Optional<User> user = userRepository.checkUserExist(driverId);
        if (! user.isPresent()) {
            return Optional.of(new ApplicationError("driverId", "Driver not found"));
        }else
            return Optional.empty();
    }

    private Optional<ApplicationError>  checkPassengerCount(Integer count) {

        if (count<=0) {
            return Optional.of(new ApplicationError("passangerCount", "Must be more than 0"));
        }else
            return Optional.empty();
    }

    private Optional<ApplicationError>  checkVehicleExistsAndBelongsToDriver (Long vehicleId, Long driverId){

        Optional<Vehicle> car = vehicleRepository.getVehicle( vehicleId );

        if (car.isPresent()) {
            Optional<Vehicle> car1 = vehicleRepository.checkVehicleBelongsToDriver( vehicleId, driverId);
            if(car1.isPresent())
                return Optional.empty();
            else
                return Optional.of(new ApplicationError("vehicleId", "Vehicle do not belongs to driver"));

        } else
            return Optional.of(new ApplicationError("vehicleId", "Not found"));

    }

    private Optional<ApplicationError> checkTimeValid(String time) {

        Pattern pattern;
        Matcher matcher;

        String TIME24HOURS_PATTERN =
                "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";

        pattern = Pattern.compile(TIME24HOURS_PATTERN);
        matcher = pattern.matcher(time);

        if(matcher.matches()){
            return Optional.empty();
        }
        else{
            return Optional.of(new ApplicationError("time", "Not not valid"));
        }



    }

}
