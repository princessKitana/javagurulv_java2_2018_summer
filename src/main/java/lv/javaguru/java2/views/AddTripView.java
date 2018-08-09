package lv.javaguru.java2.views;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.services.AddTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Scanner;

@Component
public class AddTripView implements ConsoleView {

    @Autowired
    private AddTripService addTripService = new AddTripService();

    public void execute() {

            System.out.println();
            System.out.println("---");
            Trip trip = new Trip();

        try {
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

        }catch (Exception ex) {
            //TODO chjo delatj????
            System.out.println("Not valid input");
        }

        trip.setDriverId((long) 1);//mock

        addTripService.addTrip(trip);

        System.out.println("---");
        System.out.println();
    }
}
