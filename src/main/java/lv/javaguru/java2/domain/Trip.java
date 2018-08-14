package lv.javaguru.java2.domain;

import lv.javaguru.java2.TripStatus;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="trips")
public class Trip {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="origin", nullable = false, length = 200)
    private String origin;

    @Column(name="destination", nullable = false, length = 200)
    private String destination;

    @Column(name="date", nullable = false)
    private Date date;

    @Column(name="time", nullable = false)
    private Time time;

    @Column(name="status", nullable = false)
    //@Type(type ="TripStatus")
    private String status;

    @Column(name="driverId", nullable = false) //TODO foreign key to user Id
    private Long driverId;

    @Transient
    private List<Long> passangers;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="comment",length = 200)
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
