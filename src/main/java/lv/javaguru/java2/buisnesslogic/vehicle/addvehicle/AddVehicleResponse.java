package lv.javaguru.java2.buisnesslogic.vehicle.addvehicle;

import lv.javaguru.java2.buisnesslogic.ApplicationError;

import java.util.List;

public class AddVehicleResponse {

    private boolean success;
    private Long vehicleId;
    private List<ApplicationError> errors;

    public List<ApplicationError> getErrors() {
            return errors;
        }
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setErrors(List<ApplicationError> errors) {
            this.errors = errors;
        }
        public AddVehicleResponse(Long vehicleId) {
            this.success = true;
            this.vehicleId = vehicleId;
        }

        public AddVehicleResponse(List<ApplicationError> errors) {
            this.success = false;
            this.errors = errors;
        }

        public boolean isSuccess() {
            return success;
        }
}
