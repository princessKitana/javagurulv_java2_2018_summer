package lv.javaguru.java2.domain;

import lv.javaguru.java2.buisnesslogic.TripStatus;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

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

    @Column(name="passangerCount", nullable = false)
    private int passangerCount;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    public TripStatus status;

    @ManyToOne
    @JoinColumn(name = "driverId", nullable = false )
    private User user;

    @ManyToOne
    @JoinColumn(name = "vehicleId", nullable = false )
    private Vehicle car;

    //@Transient
    //private List<Long> passangers;

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

    public int getPassangerCount() {
        return passangerCount;
    }

    public void setPassangerCount(int passangerCount) {
        this.passangerCount = passangerCount;
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

    public Vehicle getCar() {
        return car;
    }

    public void setCar(Vehicle car) {
        this.car = car;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
