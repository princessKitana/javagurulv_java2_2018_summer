package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PrintTripService {
    @Autowired
    private Database database;

    public List<Trip> getAllTrips(){
        return database.getAllTrips();
    }

}
