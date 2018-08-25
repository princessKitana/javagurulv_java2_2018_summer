package lv.javaguru.java2.buisnesslogic.addvehicle;

import lv.javaguru.java2.Error;
import lv.javaguru.java2.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VehicleValidatorImpl implements VehicleValidator {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Error> validate(AddVehicleRequest request) {

        List<Error> errors = new ArrayList<>();

        checkColorNotBlank(request.getColor()).ifPresent(errors::add);
        checkModelNotBlank(request.getModel()).ifPresent(errors::add);
        checkDriverExits(request.getDriverId()).ifPresent(errors::add);

        return errors;
    }

    private Optional<Error> checkColorNotBlank(String color) {

        if (color == null || color.isEmpty()) {
            return Optional.of(new Error("color", "Cannot be empty"));
        } else
            return Optional.empty();
    }

    private Optional<Error> checkModelNotBlank(String model) {

        if (model == null || model.isEmpty()) {
            return Optional.of(new Error("model", "Cannot be empty"));
        }else
            return Optional.empty();
    }

    private Optional<Error> checkDriverExits(Long driverId) {

        if (driverId == null) {
            return Optional.of(new Error("driverId", "Cannot be empty"));
        } else {
            if (userRepository.checkUserExist(driverId)) {
                return Optional.empty();
            } else
                return Optional.of(new Error("driverId", "Does not exist"));
        }
    }

}



