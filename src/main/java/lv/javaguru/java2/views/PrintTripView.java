package lv.javaguru.java2.views;

import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrintTripView implements ConsoleView{

    @Autowired
    private GetTripService getTripService;

    public void execute(){
        System.out.println();
        System.out.println("---");

        List<Trip> allTrips = getTripService.getAllTrips();

        for (Trip trip : allTrips) {
            System.out.println(trip.getOrigin());
            System.out.println(trip.getDestination());
            System.out.println(trip.getDate());
            System.out.println(trip.getTime());
            System.out.println(trip.getStatus());
            System.out.println("---");
        }

        System.out.println("---");
        System.out.println();
    }
}
