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

        AddTripRequest trip = createTrip();
        trip.setDestination( null );
        trip.setOrigin( null );

        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );

        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));

        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(2, applicationErrors.size());
        assertEquals("origin", applicationErrors.get(0).getField() );
        assertEquals("Cannot be empty", applicationErrors.get(0).getDescription());

        assertEquals("destination", applicationErrors.get(1).getField() );
        assertEquals("Cannot be empty", applicationErrors.get(1).getDescription());
    }

    @Test
    public void shouldReturnErrorsWhenOriginAndDestinationAreEmpty() {

        AddTripRequest trip = createTrip();
        trip.setDestination( "" );
        trip.setOrigin( "" );

        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(2, applicationErrors.size());
        assertEquals("origin", applicationErrors.get(0).getField() );
        assertEquals( "Cannot be empty", applicationErrors.get(0).getDescription());

        assertEquals("destination", applicationErrors.get(1).getField() );
        assertEquals( "Cannot be empty", applicationErrors.get(1).getDescription());
    }

    @Test
    public void shouldReturnErrorWhenDateBlank() {

        AddTripRequest trip = createTrip();
        trip.setDate( "" );

        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(1, applicationErrors.size());
        assertEquals("date", applicationErrors.get(0).getField() );
        assertEquals( "Date must be filled", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenDateInPast(){

        AddTripRequest trip = createTrip();
        trip.setDate("2017-07-06");

        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(1, applicationErrors.size());
        assertEquals("date", applicationErrors.get(0).getField() );
        assertEquals( "Date must be in future", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenPriceNegative(){

        AddTripRequest trip = createTrip();
        trip.setPrice( String.valueOf( -6.99 ) );

        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(1, applicationErrors.size());
        assertEquals("price", applicationErrors.get(0).getField() );
        assertEquals( "Must be from 0.00 to 100.00", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenPriceTooHigh(){

        AddTripRequest trip = createTrip();
        trip.setPrice("100.01");

        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(1, applicationErrors.size());
        assertEquals("price", applicationErrors.get(0).getField() );
        assertEquals( "Must be from 0.00 to 100.00", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldNotReturnErrorWhenAllOk() {

        AddTripRequest trip = createTrip();

        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.ofNullable( user ) );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(0, applicationErrors.size());

    }

    @Test
    public void shouldReturnErrorWhenDriverNotExist() {

        AddTripRequest trip = createTrip();
        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn( Optional.empty() );
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));


        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(1, applicationErrors.size());
        assertEquals("driverId", applicationErrors.get(0).getField() );
        assertEquals( "Driver not found", applicationErrors.get(0).getDescription());

    }


    @Test
    public void shouldReturnErrorWhenPassangerCountZero() {

        AddTripRequest trip = createTrip();
        trip.setPassangerCount("0");

        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);
        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn(Optional.ofNullable( user ));
        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> errors = validator.validate(trip);

        assertEquals(1, errors.size());
        assertEquals("passangerCount", errors.get(0).getField() );
        assertEquals( "Must be more than 0", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenVehicleNotFound() {

        AddTripRequest trip = createTrip();
        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn(Optional.ofNullable( user ));

        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.empty());


        List<ApplicationError> errors = validator.validate(trip);

        assertEquals(1, errors.size());
        assertEquals("vehicleId", errors.get(0).getField() );
        assertEquals( "Not found", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenVehicleNotBelongsToDriver() {

        AddTripRequest trip = createTrip();
        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( user.getId()))
                .thenReturn(Optional.ofNullable( user ));

        Mockito.when( vehicleRepository.getVehicle( car.getId()))
                .thenReturn(Optional.ofNullable( car ));

        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( car.getId(), user.getId()))
                .thenReturn(Optional.empty());


        List<ApplicationError> errors = validator.validate(trip);

        assertEquals(1, errors.size());
        assertEquals("vehicleId", errors.get(0).getField() );
        assertEquals( "Vehicle do not belongs to driver", errors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenTimeInvalid(){

        AddTripRequest trip = createTrip();
        trip.setTime( "94:0698" );
        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( Long.valueOf( trip.getDriverId() ) ))
                .thenReturn(Optional.ofNullable( user ));
        Mockito.when( vehicleRepository.getVehicle( Long.valueOf( trip.getDriverId() ) ))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver(Long.valueOf(  trip.getDriverId()), Long.valueOf( trip.getDriverId())))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(1, applicationErrors.size());
        assertEquals("time", applicationErrors.get(0).getField() );
        assertEquals( "Not not valid", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenDateInvalid(){

        AddTripRequest trip = createTrip();
        trip.setDate( "94-069-8" );

        Vehicle car = new Vehicle();
        car.setId(  (long) 3);

        User user = new User();
        user.setId((long) 3);

        Mockito.when( userRepository.checkUserExist( Long.valueOf( trip.getDriverId() ) ))
                .thenReturn(Optional.ofNullable( user ));
        Mockito.when( vehicleRepository.getVehicle( Long.valueOf( trip.getDriverId() ) ))
                .thenReturn(Optional.ofNullable( car ));
        Mockito.when( vehicleRepository.checkVehicleBelongsToDriver( Long.valueOf(  trip.getDriverId()), Long.valueOf( trip.getDriverId())))
                .thenReturn(Optional.ofNullable( car ));

        List<ApplicationError> applicationErrors = validator.validate(trip);

        assertEquals(1, applicationErrors.size());
        assertEquals("date", applicationErrors.get(0).getField() );
        assertEquals( "Date not valid", applicationErrors.get(0).getDescription());

    }

    public AddTripRequest createTrip() {
        AddTripRequest trip = new AddTripRequest();

        trip.setDriverId( "3");
        trip.setVehicleId( "3");
        trip.setOrigin("Riga");
        trip.setDestination("Liepaja");
        trip.setDate("2022-07-06");
        trip.setTime("14:00:00");
        trip.setComment("will pick up at Alfa");
        trip.setPrice("2.56");
        trip.setPassangerCount("2");

        return trip;
    }


}
