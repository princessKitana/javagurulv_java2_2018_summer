package lv.javaguru.java2.applyForTripTests;

import lv.javaguru.java2.buisnesslogic.applyForTrip.*;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import lv.javaguru.java2.Error;
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

        List<Error> errors = Collections.singletonList(
                new Error("tripId", "Cannot be empty")
        );

        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        ApplyForTripResponse response = service.applyForTrip(request);

        assertFalse(response.isSuccess());
    }
}
