package lv.javaguru.java2.buisnesslogic.vehicle.addvehicle;

import lv.javaguru.java2.buisnesslogic.ApplicationError;

import java.util.List;

public interface VehicleValidator {

    List<ApplicationError> validate(AddVehicleRequest request);
}
