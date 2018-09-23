package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Vehicle;

import java.util.Optional;

public interface VehicleRepository {
    void addVehicle(Vehicle car);

    Optional<Vehicle> getVehicle(Long vehicleId);

    Optional<Vehicle> checkVehicleBelongsToDriver(Long vehicleId, Long driverId);
}
