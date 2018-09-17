package lv.javaguru.java2.buisnesslogic.vehicle.addvehicle;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
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
    public List<ApplicationError> validate(AddVehicleRequest request) {

        List<ApplicationError> errors = new ArrayList<>();

        checkColorNotBlank(request.getColor()).ifPresent(errors::add);
        checkModelNotBlank(request.getModel()).ifPresent(errors::add);
        checkDriverExits(request.getDriverId()).ifPresent(errors::add);

        return errors;
    }

    private Optional<ApplicationError> checkColorNotBlank(String color) {

        if (color == null || color.isEmpty()) {
            return Optional.of(new ApplicationError("color", "Cannot be empty"));
        } else
            return Optional.empty();
    }

    private Optional<ApplicationError> checkModelNotBlank(String model) {

        if (model == null || model.isEmpty()) {
            return Optional.of(new ApplicationError("model", "Cannot be empty"));
        }else
            return Optional.empty();
    }

    private Optional<ApplicationError> checkDriverExits(Long driverId) {

        if (driverId == null) {
            return Optional.of(new ApplicationError("driverId", "Cannot be empty"));
        } else {
            Optional<User> user = userRepository.checkUserExist(driverId);
            if (user.isPresent()) {
                return Optional.empty();
            } else
                return Optional.of(new ApplicationError("driverId", "Does not exist"));
        }
    }

}



