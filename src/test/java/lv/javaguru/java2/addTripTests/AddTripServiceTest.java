package lv.javaguru.java2.addTripTests;

import lv.javaguru.java2.buisnesslogic.addtrip.*;
import lv.javaguru.java2.Error;
import lv.javaguru.java2.domain.Trip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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
        Trip trip = new Trip();
        AddTripRequest request = new AddTripRequest(trip);

        List<Error> errors = Collections.singletonList(
                new Error("origin", "Cannot be empty")
        );

        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        AddTripResponse response = service.addTrip(request);

        assertFalse(response.isSuccess());
    }

}
