package lv.javaguru.java2.domain;

import javax.persistence.*;

@Entity
@Table(name="tripPassangers")
public class TripPassanger {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "tripId", nullable = false)
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "passangerId", nullable = false)
    private User passanger;

    public User getUser() {
        return passanger;
    }

    public void setUser(User user) {
        this.passanger = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
