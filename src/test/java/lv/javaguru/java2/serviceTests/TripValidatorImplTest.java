package lv.javaguru.java2.serviceTests;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.validator.TripValidator;
import lv.javaguru.java2.validator.TripValidatorImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TripValidatorImplTest {

    @Mock
    private Database database;

    @InjectMocks
    private TripValidator validator = new TripValidatorImpl();

    @Test
    public void shouldReturnErrorsWhenOriginAndDestinationAreNull() throws ParseException {

        Trip trip = new Trip();

        long time = System.currentTimeMillis()+1000;
        Date date = new Date(time);
        trip.setDate(date);

        LocalTime time1 = LocalTime.of(22, 15);
        trip.setTime(time1);
        trip.setDriverId((long) 1123);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(2.56);
        trip.setStatus("PENDING");

        List<Error> errors = validator.validate(trip);

        assertEquals(2, errors.size());
        assertEquals("origin", errors.get(0).getField() );
        assertEquals( "Cannot be empty", errors.get(0).getDescription());

        assertEquals("destination", errors.get(1).getField() );
        assertEquals( "Cannot be empty", errors.get(1).getDescription());
    }

    @Test
    public void shouldReturnErrorsWhenOriginAndDestinationAreEmpty() throws ParseException {

        Trip trip = new Trip();

        long time = System.currentTimeMillis()+1000;
        Date date = new Date(time);
        trip.setDate(date);

        LocalTime time1 = LocalTime.of(22, 15);
        trip.setTime(time1);
        trip.setDriverId((long) 1123);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(2.56);
        trip.setStatus("PENDING");
        trip.setOrigin("");
        trip.setDestination("");

        List<Error> errors = validator.validate(trip);

        assertEquals(2, errors.size());
        assertEquals("origin", errors.get(0).getField() );
        assertEquals( "Cannot be empty", errors.get(0).getDescription());

        assertEquals("destination", errors.get(1).getField() );
        assertEquals( "Cannot be empty", errors.get(1).getDescription());
    }

    @Test
    public void shouldReturnErrorWhenDateInPast() throws ParseException {

        Trip trip = new Trip();

        long time = System.currentTimeMillis()-1000;
        Date date = new Date(time);
        trip.setDate(date);

        LocalTime time1 = LocalTime.of(22, 15);
        trip.setTime(time1);
        trip.setDriverId((long) 1123);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(2.56);
        trip.setStatus("PENDING");
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        List<Error> errors = validator.validate(trip);

        assertEquals(1, errors.size());
        assertEquals("date", errors.get(0).getField() );
        assertEquals( "Date must be set in future", errors.get(0).getDescription());

    }
}
