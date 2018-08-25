package lv.javaguru.java2.addTripTests;

import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.buisnesslogic.addtrip.AddTripRequest;
import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserValidator;
import lv.javaguru.java2.buisnesslogic.registeruser.RegisterUserValidatorImpl;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.Error;
import lv.javaguru.java2.buisnesslogic.addtrip.TripValidator;
import lv.javaguru.java2.buisnesslogic.addtrip.TripValidatorImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TripValidatorImplTest {
    @Mock
    private TripRepository database;

    @InjectMocks
    private TripValidator validator = new TripValidatorImpl();

    @Test
    public void shouldReturnErrorsWhenOriginAndDestinationAreNull() {

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2020-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        //trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);

        AddTripRequest request = new AddTripRequest(trip);
        List<Error> errors = validator.validate(request);

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
        //trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setOrigin("");
        trip.setDestination("");

        AddTripRequest request = new AddTripRequest(trip);
        List<Error> errors = validator.validate(request);

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
        //trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        AddTripRequest request = new AddTripRequest(trip);
        List<Error> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("date", errors.get(0).getField() );
        assertEquals( "Date must be filled", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenDateInPast(){

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2017-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        //trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        AddTripRequest request = new AddTripRequest(trip);
        List<Error> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("date", errors.get(0).getField() );
        assertEquals( "Date must be in future", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenPriceNegative(){

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2020-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        //trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("-2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        AddTripRequest request = new AddTripRequest(trip);
        List<Error> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("price", errors.get(0).getField() );
        assertEquals( "Must be from 0.00 to 100.00", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenPriceTooHigh(){

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2020-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        //trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("100.99"));
        trip.setStatus(TripStatus.PENDING);
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        AddTripRequest request = new AddTripRequest(trip);
        List<Error> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("price", errors.get(0).getField() );
        assertEquals( "Must be from 0.00 to 100.00", errors.get(0).getDescription());

    }

    @Test
    public void shouldNotReturnErrorWhenPriceOk() {

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2020-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        //trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setOrigin("Riga");
        trip.setDestination("Jurmala");

        AddTripRequest request = new AddTripRequest(trip);
        List<Error> errors = validator.validate(request);

        assertEquals(0, errors.size());

    }

//    @Test
//    public void shouldNotReturnErrorWhenNoDriverExists() {
//
//        Trip trip = new Trip();
//
//        trip.setDate(Date.valueOf("2020-07-06"));
//        trip.setTime(Time.valueOf("14:00:00"));
//        trip.setDriverId((long) 0);
//        trip.setComment("will pick up at Alfa");
//        trip.setPrice(Double.parseDouble("100.99"));
//        trip.setStatus("PENDING");
//        trip.setOrigin("Riga");
//        trip.setDestination("Jurmala");
//
//        List<Error> errors = validator.validate(trip);
//
//        assertEquals(1, errors.size());
//        assertEquals("driverId", errors.get(0).getField() );
//        assertEquals( "Driver not found", errors.get(0).getDescription());

 //   }
}
