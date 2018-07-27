package lv.javaguru.java2.Domain;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

public class Trip {
    private Long id;
    private String origin;
    private String destination;
    private Date date;
    private LocalTime time;
    private String status;
    private Long driverId;
    private List<Long> passangers; //?
    private Double price;
    private String comment;


    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
