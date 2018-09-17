package lv.javaguru.java2.applyForTripTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;

import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.*;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
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
public class ApplyForTripServiceTest {

    @Mock
    ApplyForTripValidator validator;

    @InjectMocks
    ApplyForTripService service =new ApplyForTripServiceImpl();

    @Test
    public void shouldReturnFailedResponseWhenValidationErrorsExist() {

        Trip trip = new Trip();
        User passanger = new User();

        ApplyForTripRequest request = new ApplyForTripRequest(trip, passanger);

        ApplicationError error = new ApplicationError( "tripId", "Cannot be empty" );

        List<ApplicationError> errors = new ArrayList<>(  );
        errors.add( error );

        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        try {
            service.applyForTrip(request);
        }catch (ApplicationException e){
            Assert.assertEquals("Cannot be empty", e.getErrors().get( 0 ).getDescription() );
            Assert.assertEquals("tripId", e.getErrors().get( 0 ).getField() );

        }

    }
}
