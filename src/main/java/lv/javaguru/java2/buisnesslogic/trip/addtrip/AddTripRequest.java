package lv.javaguru.java2.buisnesslogic.trip.addtrip;

import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.web.dtos.TripDTO;

import java.sql.Date;
import java.sql.Time;

public class AddTripRequest {

    private String origin;
    private String destination;
    private String date;
    private String time;
    private String passangerCount;
    private String price;
    private String comment;
    private String driverId;
    private String vehicleId;

    public AddTripRequest(Trip trip) {
        this.origin = trip.getOrigin();
        this.destination = trip.getDestination();
        this.date = String.valueOf( trip.getDate() );
        this.time = String.valueOf( trip.getTime() );
        this.passangerCount = String.valueOf( trip.getPassangerCount() );
        this.price = String.valueOf( trip.getPrice() );
        this.comment = trip.getComment();
        this.driverId = String.valueOf( trip.getUser().getId() );
        this.vehicleId = String.valueOf( trip.getCar().getId() );
    }

    public AddTripRequest() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPassangerCount() {
        return passangerCount;
    }

    public void setPassangerCount(String passangerCount) {
        this.passangerCount = passangerCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}
