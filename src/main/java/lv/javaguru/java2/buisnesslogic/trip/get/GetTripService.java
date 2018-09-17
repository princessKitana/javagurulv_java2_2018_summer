package lv.javaguru.java2.buisnesslogic.trip.get;

import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.domain.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface GetTripService {

     List<Trip> getAllTrips();

     GetTripResponse get(GetTripRequest request);
}
