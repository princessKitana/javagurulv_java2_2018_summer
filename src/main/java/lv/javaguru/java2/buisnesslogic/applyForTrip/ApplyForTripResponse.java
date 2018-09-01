package lv.javaguru.java2.buisnesslogic.applyForTrip;

import lv.javaguru.java2.Error;

import java.util.List;

public class ApplyForTripResponse {

    private boolean success;
    private Long tripId;
    private List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public ApplyForTripResponse(Long tripId) {
        this.success = true;
        this.tripId = tripId;
    }

    public ApplyForTripResponse(List<Error> errors) {
        this.success = false;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }
}
