package lv.javaguru.java2.addTripTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.*;
import lv.javaguru.java2.domain.Trip;
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
public class AddTripServiceTest {

    @Mock private TripValidator validator;

    @InjectMocks
    private AddTripService service = new AddTripServiceImpl();

    @Test
    public void shouldReturnFailedResponseWhenValidationErrorsExist() {

        Vehicle car = new Vehicle();
        car.setId(  (long) 1);

        User user = new User();
        user.setId((long) 1);

        Trip trip = new Trip();
        trip.setCar(car);
        trip.setUser(user);
        trip.setPassangerCount( 2 );

        AddTripRequest request = new AddTripRequest(trip);

        ApplicationError error = new ApplicationError("origin", "Cannot be empty");
        List<ApplicationError> errors = new ArrayList<>(  );
        errors.add( error );

        Mockito.when(validator.validate(request))
                .thenReturn( errors);

        try {
            service.addTrip(request);
        }catch (ApplicationException e){
            Assert.assertEquals("Cannot be empty", e.getErrors().get( 0 ).getDescription() );
            Assert.assertEquals("origin", e.getErrors().get( 0 ).getField() );

        }
    }

}
