package lv.javaguru.java2.buisnesslogic.trip.get;

import lv.javaguru.java2.web.dtos.TripDTO;

public class GetTripResponse {

TripDTO trip;

    public GetTripResponse(TripDTO trip) {
        this.trip = trip;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }
}
