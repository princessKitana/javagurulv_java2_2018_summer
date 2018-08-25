package lv.javaguru.java2.buisnesslogic.addvehicle;

import lv.javaguru.java2.Error;

import java.util.List;

public interface VehicleValidator {

    List<Error> validate(AddVehicleRequest request);
}
