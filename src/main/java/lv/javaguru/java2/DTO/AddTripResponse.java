package lv.javaguru.java2.DTO;

import java.util.List;

public class AddTripResponse {
    private boolean success;
    private Long tripId;
    private List<Error> errors;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public AddTripResponse(Long tripId) {
        this.success = true;
        this.tripId = tripId;
    }

    public AddTripResponse(List<Error> errors) {
        this.success = false;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }
}
