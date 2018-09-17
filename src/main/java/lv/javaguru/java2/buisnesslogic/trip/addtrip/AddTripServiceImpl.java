package lv.javaguru.java2.buisnesslogic.trip.addtrip;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AddTripServiceImpl implements AddTripService{

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripValidator validator;

    @Transactional
    @Override
    public AddTripResponse addTrip(AddTripRequest request){

        List<ApplicationError> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            throw new ApplicationException(validationErrors);
        }

        Trip trip = new Trip();

        User driver = new User();
        driver.setId(request.getDriverId());

        Vehicle car = new Vehicle();
        car.setId(request.getDriverId());

        trip.setUser(driver);
        trip.setCar(car);
        trip.setPassangerCount(request.getPassangerCount());
        trip.setDestination(request.getDestination());
        trip.setOrigin(request.getOrigin());
        trip.setPrice(request.getPrice());
        trip.setComment(request.getComment());
        trip.setTime(request.getTime());
        trip.setDate(request.getDate());
        trip.setStatus(TripStatus.PENDING);

        tripRepository.addTrip(trip);

        return new AddTripResponse(trip.getId());
    }
}
