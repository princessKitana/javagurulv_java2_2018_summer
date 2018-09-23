package lv.javaguru.java2.web.dtos;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.domain.Trip;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TripDTO {

    private Long id;
    private String origin;
    private String destination;
    private Date date;
    private String time;
    private Integer passangerCount;
    private Double price;
    private String status;
    private Long driverId;
    private Long vehicleId;
    private String comment;

    public TripDTO(){
    }

    public TripDTO(Trip trip) {
        this.id = trip.getId();
        this.origin = trip.getOrigin();
        this.destination = trip.getDestination();
        this.date = trip.getDate();
        this.time = String.valueOf( trip.getTime() );
        this.status = String.valueOf( trip.getStatus() );
        this.passangerCount = trip.getPassangerCount();
        this.price = trip.getPrice();
        this.driverId = trip.getUser().getId();
        this.vehicleId = trip.getCar().getId();
        this.comment = trip.getComment();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPassangerCount() {
        return passangerCount;
    }

    public void setPassangerCount(int passangerCount) {
        this.passangerCount = passangerCount;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
