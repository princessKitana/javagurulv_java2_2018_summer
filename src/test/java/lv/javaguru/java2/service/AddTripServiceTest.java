package lv.javaguru.java2.service;

import lv.javaguru.java2.DTO.AddTripResponse;
import lv.javaguru.java2.DTO.Error;
import lv.javaguru.java2.Domain.Trip;
import lv.javaguru.java2.Validator.TripValidator;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.services.AddTripService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class AddTripServiceTest {

    private Database database;
    private AddTripService service;
    private TripValidator validator;

    @Before
    public void init() {

        database = Mockito.mock(Database.class);
        validator = Mockito.mock(TripValidator.class);
        service = new AddTripService(validator, database);
    }

    @Test
    public void shouldReturnFailedResponseWhenValidationErrorsExist() {
        Trip trip = new Trip();
        trip.setOrigin("");
        trip.setDestination("Liepaja");
        long time = System.currentTimeMillis();
        LocalTime time1 = LocalTime.of(22, 15);
        trip.setDate(new Date(time));
        trip.setTime(time1);
        trip.setDriverId((long) 1123);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(2.56);
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
