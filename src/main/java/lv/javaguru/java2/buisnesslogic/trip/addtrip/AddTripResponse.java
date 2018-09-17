package lv.javaguru.java2.buisnesslogic.trip.addtrip;

import lv.javaguru.java2.buisnesslogic.ApplicationError;

import java.util.List;

public class AddTripResponse {
    private boolean success;
    private Long tripId;
    private List<ApplicationError> applicationErrors;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public List<ApplicationError> getApplicationErrors() {
        return applicationErrors;
    }

    public void setApplicationErrors(List<ApplicationError> applicationErrors) {
        this.applicationErrors = applicationErrors;
    }

    public AddTripResponse(Long tripId) {
        this.success = true;
        this.tripId = tripId;
    }

    public AddTripResponse(List<ApplicationError> applicationErrors) {
        this.success = false;
        this.applicationErrors = applicationErrors;
    }

    public boolean isSuccess() {
        return success;
    }
}
