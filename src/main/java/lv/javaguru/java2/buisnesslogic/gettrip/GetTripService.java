package lv.javaguru.java2.buisnesslogic.gettrip;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.domain.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GetTripService {
    @Autowired
    private TripRepository database;

    public List<Trip> getAllTrips(){
        return database.getAllTrips();
    }

}
