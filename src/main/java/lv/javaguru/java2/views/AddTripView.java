package lv.javaguru.java2.views;

import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripRequest;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

@Component
public class AddTripView implements ConsoleView {

    @Autowired
    private AddTripService addTripService;

    public void execute() {

        System.out.println();
        System.out.println("---");
        Trip trip = new Trip();

        try {
            userInput(trip);
        }catch (Exception ex) {
            System.out.println("Not valid input");
            userInput(trip);
        }

        //trip.setDriverId((long) 1);//mock;  TODO need to set user id
        trip.setStatus(TripStatus.PENDING);

        AddTripRequest request = new AddTripRequest(trip);
        addTripService.addTrip(request);

        System.out.println("---");
        System.out.println();
    }


    private void userInput(Trip trip){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter trip origin:");
        trip.setOrigin(sc.nextLine());
        System.out.print("Enter trip destination:");
        trip.setDestination(sc.nextLine());

        System.out.print("Enter trip date:");
        trip.setDate(Date.valueOf(sc.nextLine()));

        System.out.print("Enter trip time:");
        trip.setTime(Time.valueOf(sc.nextLine()));

        System.out.print("Enter trip price:");
        trip.setPrice(Double.parseDouble(sc.nextLine()));

        System.out.print("Enter trip comment(optional):");
        trip.setComment(sc.nextLine());

    }
}
