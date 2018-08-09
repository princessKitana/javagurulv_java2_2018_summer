package lv.javaguru.java2.serviceTests;

import lv.javaguru.java2.dto.AddTripResponse;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.validator.TripValidator;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.services.AddTripService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class AddTripServiceTest {

    @Mock
    private Database database;

    @Mock private TripValidator validator;

    @InjectMocks
    private AddTripService service = new AddTripService();

    @Test
    public void shouldReturnFailedResponseWhenValidationErrorsExist() {
        Trip trip = new Trip();
        trip.setOrigin("");
        trip.setDestination("Liepaja");
        trip.setDate(Date.valueOf("2018-07-06"));
        trip.setTime(Time.valueOf("14.00"));
        trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus("PENDING");

        List<Error> errors = Collections.singletonList(
                new Error("origin", "Cannot be empty")
        );

        Mockito.when(validator.validate(trip))
                .thenReturn(errors);

        AddTripResponse response = service.addTrip(trip);

        assertFalse(response.isSuccess());
    }

}
