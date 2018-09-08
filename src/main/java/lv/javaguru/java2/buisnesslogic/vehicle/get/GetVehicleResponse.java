package lv.javaguru.java2.buisnesslogic.vehicle.get;

import lv.javaguru.java2.web.dtos.VehicleDTO;

public class GetVehicleResponse {

    private VehicleDTO car;

    public VehicleDTO getCar() {
        return car;
    }

    public void setCar(VehicleDTO car) {
        this.car = car;
    }

    public GetVehicleResponse(VehicleDTO car) {
        this.car = car;
    }
}
