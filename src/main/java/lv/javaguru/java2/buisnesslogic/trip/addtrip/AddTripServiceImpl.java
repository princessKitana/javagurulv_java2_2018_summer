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

import java.sql.Date;
import java.sql.Time;
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
        driver.setId( Long.valueOf( request.getDriverId() ) );

        Vehicle car = new Vehicle();
        car.setId( Long.valueOf( request.getVehicleId() ) );

        trip.setUser(driver);
        trip.setCar(car);
        trip.setPassangerCount( Integer.parseInt( request.getPassangerCount() ) );
        trip.setDestination(request.getDestination());
        trip.setOrigin(request.getOrigin());
        trip.setPrice( Double.valueOf( request.getPrice() ) );
        trip.setComment(request.getComment());
        trip.setTime( Time.valueOf( request.getTime() ) );
        trip.setDate( Date.valueOf(request.getDate()));
        trip.setStatus(TripStatus.PENDING);

        tripRepository.addTrip(trip);

        return new AddTripResponse(trip.getId());
    }
}
