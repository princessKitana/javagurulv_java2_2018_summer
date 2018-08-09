package lv.javaguru.java2.serviceTests;

import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.dto.Error;
import lv.javaguru.java2.validator.TripValidator;
import lv.javaguru.java2.validator.TripValidatorImpl;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TripValidatorImplTest {

    @InjectMocks
    private TripValidator validator = new TripValidatorImpl();

    @Test
    public void shouldReturnErrorsWhenOriginAndDestinationAreNull() {

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2020-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus("PENDING");

        List<Error> errors = validator.validate(trip);

        assertEquals(2, errors.size());
        assertEquals("origin", errors.get(0).getField() );
        assertEquals("Cannot be empty", errors.get(0).getDescription());

        assertEquals("destination", errors.get(1).getField() );
        assertEquals("Cannot be empty", errors.get(1).getDescription());
    }

    @Test
    public void shouldReturnErrorsWhenOriginAndDestinationAreEmpty() {

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2020-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
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
    public void shouldReturnErrorWhenDateBlank() {

        Trip trip = new Trip();

        trip.setTime(Time.valueOf("14:00:00"));
        trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus("PENDING");
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        List<Error> errors = validator.validate(trip);

        assertEquals(1, errors.size());
        assertEquals("date", errors.get(0).getField() );
        assertEquals( "Date must be filled", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenDateInPast(){

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2017-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus("PENDING");
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        List<Error> errors = validator.validate(trip);

        assertEquals(1, errors.size());
        assertEquals("date", errors.get(0).getField() );
        assertEquals( "Date must be in future", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenPriceNegative(){

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2020-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("-2.56"));
        trip.setStatus("PENDING");
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        List<Error> errors = validator.validate(trip);

        assertEquals(1, errors.size());
        assertEquals("price", errors.get(0).getField() );
        assertEquals( "Must be from 0.00 to 100.00", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenPriceTooHigh(){

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2020-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("100.99"));
        trip.setStatus("PENDING");
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        List<Error> errors = validator.validate(trip);

        assertEquals(1, errors.size());
        assertEquals("price", errors.get(0).getField() );
        assertEquals( "Must be from 0.00 to 100.00", errors.get(0).getDescription());

    }

    @Test
    public void shouldNotReturnErrorWhenPriceOk() {

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2020-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus("PENDING");
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        List<Error> errors = validator.validate(trip);

        assertEquals(0, errors.size());

    }

}
