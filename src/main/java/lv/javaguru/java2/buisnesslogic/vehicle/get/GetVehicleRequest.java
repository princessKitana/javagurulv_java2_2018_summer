package lv.javaguru.java2.buisnesslogic.vehicle.get;

public class GetVehicleRequest {

    private Long vehicleId;

    public GetVehicleRequest(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }
}
