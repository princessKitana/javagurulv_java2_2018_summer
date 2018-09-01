package lv.javaguru.java2.buisnesslogic.applyForTrip;

import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;


public class ApplyForTripRequest {

    private Trip trip;
    private User passanger;

    public ApplyForTripRequest(Trip trip, User passanger) {
        this.trip = trip;
        this.passanger = passanger;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public User getPassanger() {
        return passanger;
    }

    public void setPassanger(User passanger) {
        this.passanger = passanger;
    }
}
