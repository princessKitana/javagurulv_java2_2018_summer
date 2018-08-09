package lv.javaguru.java2.domain;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

public class Trip {
    private Long id;
    private String origin;
    private String destination;
    private Date date;
    private Time time;
    private String status ="PENDING";
    private Long driverId;
    private List<Long> passangers;
    private Double price;
    private String comment;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public List<Long> getPassangers() {
        return passangers;
    }

    public void setPassangers(List<Long> passangers) {
        this.passangers = passangers;
    }


}
