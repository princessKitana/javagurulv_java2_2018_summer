package lv.javaguru.java2.buisnesslogic.trip.get;

import lv.javaguru.java2.web.dtos.TripDTO;

import java.util.List;

public class GetAllTripsResponse {

    List<TripDTO> trips;

    public GetAllTripsResponse(List<TripDTO> trips) {
        this.trips = trips;
    }

    public List<TripDTO> getTrips() {
        return trips;
    }

    public void setTrips(List<TripDTO> trips) {
        this.trips = trips;
    }
}
