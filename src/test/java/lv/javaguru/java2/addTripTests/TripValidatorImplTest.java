package lv.javaguru.java2.addTripTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripRequest;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.database.VehicleRepository;
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
    private UserRepository userRepository;

    @Mock
    private VehicleRepository vehicleRepository;

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

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );

        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));

        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

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

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

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

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

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

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

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

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

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

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

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

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

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
        user.setId((long) 1);

        trip.setCar(car);
        trip.setUser(user);
        trip.setDate(Date.valueOf("2020-09-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus(TripStatus.PENDING);
        trip.setPassangerCount( 2);
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.empty() );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> applicationErrors = validator.validate(request);

        assertEquals(1, applicationErrors.size());
        assertEquals("driverId", applicationErrors.get(0).getField() );
        assertEquals( "Driver not found", applicationErrors.get(0).getDescription());

    }


    @Test
    public void shouldReturnErrorWhenPassangerCountZero() {

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
        trip.setPassangerCount(0);
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn(Optional.ofNullable( user ));
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("passangerCount", errors.get(0).getField() );
        assertEquals( "Must be more than 0", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenVehicleNotFound() {

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
        trip.setPassangerCount(2);
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn(Optional.ofNullable( user ));

        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.empty());

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("vehicleId", errors.get(0).getField() );
        assertEquals( "Not found", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenVehicleNotBelongsToDriver() {

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
        trip.setPassangerCount(2);
        trip.setOrigin( "Riga" );
        trip.setDestination( "Valmiera" );

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn(Optional.ofNullable( user ));

        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));

        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.empty());

        AddTripRequest request = new AddTripRequest(trip);
        List<ApplicationError> errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("vehicleId", errors.get(0).getField() );
        assertEquals( "Vehicle do not belongs to driver", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenTimeInvalid(){

        AddTripRequest trip = createTrip();
        trip.setTime( "94:0698" );


        Vehicle car = new Vehicle();
        car.setId(  (long) 1);

        User user = new User();
        user.setId((long) 1);

        Mockito.when( userRepository.checkUserExist( trip.getDriverId()))
                .thenReturn(Optional.ofNullable( user ));
        Mockito.when( vehicleRepository.getVehicle( trip.getDriverId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( trip.getDriverId(), trip.getDriverId()))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(1, applicationErrors.size());
        assertEquals("time", applicationErrors.get(0).getField() );
        assertEquals( "Not not valid", applicationErrors.get(0).getDescription());

    }


    public AddTripRequest createTrip() {
        AddTripRequest trip = new AddTripRequest();

        trip.setDriverId((long) 3);
        trip.setVehicleId((long) 3);
        trip.setOrigin("Riga");
        trip.setDestination("Liepaja");
        trip.setDate(Date.valueOf("2022-07-06"));
        trip.setTime("14:00:00");
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setPassangerCount(2);

        return trip;
    }
}
