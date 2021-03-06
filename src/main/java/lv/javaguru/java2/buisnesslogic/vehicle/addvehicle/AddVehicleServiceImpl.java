package lv.javaguru.java2.buisnesslogic.vehicle.addvehicle;


import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.database.VehicleRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AddVehicleServiceImpl implements AddVehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleValidator validator;

    @Transactional
    @Override
    public AddVehicleResponse addVehicle(AddVehicleRequest request){

        List<ApplicationError> validationErrors = validator.validate(request);
        if (!validationErrors.isEmpty()) {
            throw new ApplicationException(validationErrors);
        }

        Vehicle car = new Vehicle();
        car.setRegNumber(request.getRegNumber());
        car.setYear(request.getYear());
        car.setModel(request.getModel());
        car.setColor(request.getColor());

        User driver = new User();
        driver.setId(request.getDriverId());
        car.setUser(driver);

        vehicleRepository.addVehicle(car);

        userRepository.setUserAsDriver(driver);

        return new AddVehicleResponse(car.getId());
    }
}
