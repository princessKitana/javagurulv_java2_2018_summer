package lv.javaguru.java2.buisnesslogic.addvehicle;

import lv.javaguru.java2.Error;

import java.util.List;

public class AddVehicleResponse {

    private boolean success;
    private Long vehicleId;
    private List<Error> errors;

    public List<Error> getErrors() {
            return errors;
        }
    public Long getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setErrors(List<Error> errors) {
            this.errors = errors;
        }
        public AddVehicleResponse(Long vehicleId) {
            this.success = true;
            this.vehicleId = vehicleId;
        }

        public AddVehicleResponse(List<Error> errors) {
            this.success = false;
            this.errors = errors;
        }

        public boolean isSuccess() {
            return success;
        }
}
