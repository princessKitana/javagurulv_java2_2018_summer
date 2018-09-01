package lv.javaguru.java2.addVehicleTests;

import lv.javaguru.java2.Error;
import lv.javaguru.java2.buisnesslogic.addvehicle.AddVehicleRequest;
import lv.javaguru.java2.buisnesslogic.addvehicle.VehicleValidator;
import lv.javaguru.java2.buisnesslogic.addvehicle.VehicleValidatorImpl;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.database.VehicleRepository;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AddVehicleValidatorImplTest {

    @Mock
    VehicleRepository vehicleRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    VehicleValidator validator = new VehicleValidatorImpl();


    @Test
    public void shouldReturnErrorsWhenColorAndModelNull() {
        User user = new User();
        user.setId((long) 1);

        Vehicle car = new Vehicle();
        car.setColor("");
        car.setYear(2015);
        car.setRegNumber("LR-5789");

        car.setUser(user);

        Mockito.when(userRepository.checkUserExist(user.getId()))
                .thenReturn(true);

        AddVehicleRequest req = new AddVehicleRequest(car);
        List<Error> errors = validator.validate(req);

        assertEquals(2, errors.size());
        assertEquals("color", errors.get(0).getField() );
        assertEquals("Cannot be empty", errors.get(0).getDescription());

        assertEquals("model", errors.get(1).getField() );
        assertEquals("Cannot be empty", errors.get(1).getDescription());

    }

    @Test
    public void shouldReturnErrorsWhenDriverDoesNotExist() {

        User user = new User();
        user.setId((long) 1);

        Vehicle car = new Vehicle();
        car.setUser(user);
        car.setColor("Black");
        car.setModel("Honda Accord");

        Mockito.when(userRepository.checkUserExist(user.getId()))
                .thenReturn(false);

        AddVehicleRequest req = new AddVehicleRequest(car);
        List<Error> errors = validator.validate(req);

        assertEquals(1, errors.size());
        assertEquals("driverId", errors.get(0).getField() );
        assertEquals("Does not exist", errors.get(0).getDescription());

    }
}
