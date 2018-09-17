package lv.javaguru.java2.buisnesslogic.trip.get;

public class GetTripRequest {
    Long tripId;

    public GetTripRequest(Long tripId) {
        this.tripId = tripId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }
}
