package lv.javaguru.java2.addVehicleTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.vehicle.addvehicle.*;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class AddVehicleServiceTest {

    @Mock
    private VehicleValidator validator;

    @InjectMocks
    private AddVehicleService service = new AddVehicleServiceImpl();

    @Test
    public void shouldReturnFailedResponseWhenValidationErrorsExist() {
        Vehicle car = new Vehicle();
        User user = new User();
        user.setId((long) 1);
        car.setUser(user);
        car.setColor("Black");
        car.setModel("Audi A4");

        AddVehicleRequest request = new AddVehicleRequest(car);

        ApplicationError error = new ApplicationError("model", "Cannot be empty");
        List<ApplicationError> errors = new ArrayList<>(  );
        errors.add( error );

        Mockito.when(validator.validate(request)).thenReturn(errors);

        try {
            service.addVehicle(request);
        }catch (ApplicationException e){
            Assert.assertEquals("Cannot be empty", e.getErrors().get( 0 ).getDescription() );
            Assert.assertEquals("model", e.getErrors().get( 0 ).getField() );

        }
    }
}
