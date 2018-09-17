package lv.javaguru.java2.addTripTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripRequest;
import lv.javaguru.java2.database.ORM.UserRepositoryImpl;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.TripValidator;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.TripValidatorImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TripValidatorImplTest {
    @Mock
    private UserRepository database;

    @InjectMocks
    private TripValidator validator = new TripValidatorImpl();

    @Test
    public void shouldReturnErrorsWhenOriginAndDestinationAreNull() {

        Trip trip = new Trip();
        Vehicle car = new Vehicle();
        car.setId(  (long) 1);

        User user = new User();
        user.setId((long) 1);

        trip.setCar(car);
        trip.setUser(user);
        trip.setDate(Date.valueOf("2020-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setPassangerCount( 2 );

        Mockito.when(database.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> applicationErrors = validator.validate(request);

        assertEquals(2, applicationErrors.size());
        assertEquals("origin", applicationErrors.get(0).getField() );
        assertEquals("Cannot be empty", applicationErrors.get(0).getDescription());

        assertEquals("destination", applicationErrors.get(1).getField() );
        assertEquals("Cannot be empty", applicationErrors.get(1).getDescription());
    }

    @Test
    public void shouldReturnErrorsWhenOriginAndDestinationAreEmpty() {

        Trip trip = new Trip();
        Vehicle car = new Vehicle();
        car.setId(  (long) 1);

        User user = new User();
        user.setId((long) 1);

        trip.setCar(car);
        trip.setUser(user);
        trip.setDate(Date.valueOf("2020-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setPassangerCount( 2 );
        trip.setOrigin("");
        trip.setDestination("");

        Mockito.when(database.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> applicationErrors = validator.validate(request);

        assertEquals(2, applicationErrors.size());
        assertEquals("origin", applicationErrors.get(0).getField() );
        assertEquals( "Cannot be empty", applicationErrors.get(0).getDescription());

        assertEquals("destination", applicationErrors.get(1).getField() );
        assertEquals( "Cannot be empty", applicationErrors.get(1).getDescription());
    }

    @Test
    public void shouldReturnErrorWhenDateBlank() {

        Trip trip = new Trip();
        Vehicle car = new Vehicle();
        car.setId(  (long) 1);

        User user = new User();
        user.setId((long) 1);

        trip.setCar(car);
        trip.setUser(user);
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setPassangerCount( 2 );
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when(database.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> applicationErrors = validator.validate(request);

        assertEquals(1, applicationErrors.size());
        assertEquals("date", applicationErrors.get(0).getField() );
        assertEquals( "Date must be filled", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenDateInPast(){

        Trip trip = new Trip();

        trip.setDate(Date.valueOf("2017-07-06"));

        Vehicle car = new Vehicle();
        car.setId(  (long) 1);

        User user = new User();
        user.setId((long) 1);

        trip.setCar(car);
        trip.setUser(user);
        trip.setDate(Date.valueOf("2000-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setPassangerCount( 2 );
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when(database.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> applicationErrors = validator.validate(request);

        assertEquals(1, applicationErrors.size());
        assertEquals("date", applicationErrors.get(0).getField() );
        assertEquals( "Date must be in future", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenPriceNegative(){

        Trip trip = new Trip();
        Vehicle car = new Vehicle();
        car.setId(  (long) 1);

        User user = new User();
        user.setId((long) 1);

        trip.setCar(car);
        trip.setUser(user);
        trip.setDate(Date.valueOf("2020-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("-2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setPassangerCount( 2 );
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when(database.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> applicationErrors = validator.validate(request);

        assertEquals(1, applicationErrors.size());
        assertEquals("price", applicationErrors.get(0).getField() );
        assertEquals( "Must be from 0.00 to 100.00", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenPriceTooHigh(){

        Trip trip = new Trip();
        Vehicle car = new Vehicle();
        car.setId(  (long) 1);

        User user = new User();
        user.setId((long) 1);

        trip.setCar(car);
        trip.setUser(user);
        trip.setDate(Date.valueOf("2020-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("100.01"));
        trip.setStatus(TripStatus.PENDING);
        trip.setPassangerCount( 2 );
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when(database.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> applicationErrors = validator.validate(request);

        assertEquals(1, applicationErrors.size());
        assertEquals("price", applicationErrors.get(0).getField() );
        assertEquals( "Must be from 0.00 to 100.00", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldNotReturnErrorWhenPriceOk() {

        Trip trip = new Trip();
        Vehicle car = new Vehicle();
        car.setId(  (long) 1);

        User user = new User();
        user.setId((long) 1);

        trip.setCar(car);
        trip.setUser(user);
        trip.setDate(Date.valueOf("2020-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setPassangerCount( 2 );
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when(database.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> applicationErrors = validator.validate(request);

        assertEquals(0, applicationErrors.size());

    }

    @Test
    public void shouldReturnErrorWhenDriverNotExist() {

Trip trip = new Trip();
    Vehicle car = new Vehicle();
        car.setId(  (long) 1);

    User user = new User();
        user.setId((long) 66);

        trip.setCar(car);
        trip.setUser(user);
        trip.setDate(Date.valueOf("2020-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setPassangerCount( 2 );
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when(database.checkUserExist( user.getId()))
                .thenReturn(java.util.Optional.empty());

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("driverId", errors.get(0).getField() );
        assertEquals( "Driver not found", errors.get(0).getDescription());

    }


//    @Test
//    public void shouldReturnErrorWhenTimeInvalid(){
//
//        Trip trip = new Trip();
//        Vehicle car = new Vehicle();
//        car.setId(  (long) 1);
//
//        User user = new User();
//        user.setId((long) 1);
//
//        trip.setCar(car);
//        trip.setUser(user);
//        trip.setDate(Date.valueOf("2020-09-06"));
//        trip.setTime(Time.valueOf("19:00:60")); //TODO cannot validate time
//        trip.setComment("will pick up at Alfa");
//        trip.setPrice(Double.parseDouble("0.01"));
//        trip.setStatus(TripStatus.PENDING);
//        trip.setPassangerCount( 2 );
//        trip.setOrigin( "Riga" );
//        trip.setDestination( "Valmiera" );
//
//        Mockito.when(database.checkUserExist( user.getId()))
//                .thenReturn( Optional.ofNullable( user ) );
//
//
//        AddTripRequest request = new AddTripRequest(trip);
//        List<ApplicationError> applicationErrors = validator.validate(request);
//
//        assertEquals(1, applicationErrors.size());
//        assertEquals("time", applicationErrors.get(0).getField() );
//        assertEquals( "Not not valid 1", applicationErrors.get(0).getDescription());
//
//    }
}
