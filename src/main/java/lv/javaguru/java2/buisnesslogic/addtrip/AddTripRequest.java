package lv.javaguru.java2.buisnesslogic.addtrip;

import lv.javaguru.java2.domain.Trip;
import java.sql.Date;
import java.sql.Time;

public class AddTripRequest {

    private String origin;
    private String destination;
    private Date date;
    private Time time;
    private int passangerCount;
    private Double price;
    private String comment;
    private Long driverId;
    private Long vehicleId;

    public AddTripRequest(Trip trip) {
        this.origin = trip.getOrigin();
        this.destination = trip.getDestination();
        this.date = trip.getDate();
        this.time = trip.getTime();
        this.passangerCount = trip.getPassangerCount();
        this.price = trip.getPrice();
        this.comment = trip.getComment();
        this.driverId = trip.getUser().getId();
        this.vehicleId = trip.getCar().getId();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPassangerCount() {
        return passangerCount;
    }

    public void setPassangerCount(int passangerCount) {
        this.passangerCount = passangerCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
