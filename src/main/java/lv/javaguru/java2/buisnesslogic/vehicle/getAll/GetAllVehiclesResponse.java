package lv.javaguru.java2.buisnesslogic.vehicle.getAll;

import lv.javaguru.java2.web.dtos.VehicleDTO;

import java.util.List;

public class GetAllVehiclesResponse {

    private List<VehicleDTO> cars;

    public GetAllVehiclesResponse(List<VehicleDTO> cars) {
        this.cars = cars;
    }

    public List<VehicleDTO> getCars() {
        return cars;
    }

    public void setCars(List<VehicleDTO> cars) {
        this.cars = cars;
    }
}
