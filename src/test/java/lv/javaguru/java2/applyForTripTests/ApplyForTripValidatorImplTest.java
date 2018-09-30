package lv.javaguru.java2.applyForTripTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripValidator;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripValidatorImpl;
import lv.javaguru.java2.database.TripPassangerRepository;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.TripPassanger;
import lv.javaguru.java2.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ApplyForTripValidatorImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    TripRepository tripRepository;

    @Mock
    TripPassangerRepository tripPassangerRepository;

    @InjectMocks
    ApplyForTripValidator validator = new ApplyForTripValidatorImpl();

    @Test
    public void shouldReturnErrorsWhenPassangerAndTripNull() {
        User passanger = new User();
        Trip trip = new Trip();

        ApplyForTripRequest req = new ApplyForTripRequest(trip, passanger);
        List<ApplicationError> applicationErrors = validator.validate(req);

        assertEquals(2, applicationErrors.size());
        assertEquals("userId", applicationErrors.get(0).getField() );
        assertEquals("Cannot be empty", applicationErrors.get(0).getDescription());

        assertEquals("tripId", applicationErrors.get(1).getField() );
        assertEquals("Cannot be empty", applicationErrors.get(1).getDescription());

    }


    @Test
    public void shouldReturnErrorWhenTripAndPassangerDoesNotExist() {
        User passanger = new User();
        passanger.setId((long) 9999);
        Trip trip = new Trip();
        trip.setId((long) 77777);

        Mockito.when(tripRepository.checkTripExist(trip.getId(), TripStatus.PENDING))
               .thenReturn(false);

        Mockito.when(userRepository.checkUserExist(passanger.getId()))
                .thenReturn( Optional.empty() );

        ApplyForTripRequest req = new ApplyForTripRequest(trip, passanger);
        List<ApplicationError> applicationErrors = validator.validate(req);

        assertEquals(2, applicationErrors.size());

        assertEquals("userId", applicationErrors.get(0).getField() );
        assertEquals("Does not exist", applicationErrors.get(0).getDescription());

        assertEquals("tripId", applicationErrors.get(1).getField() );
        assertEquals("Does not exist", applicationErrors.get(1).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenPassangerAppliesForTripSecondTime() {
        User passanger = new User();
        passanger.setId((long) 9999);
        Trip trip = new Trip();
        trip.setId((long) 77777);

        TripPassanger tp = new TripPassanger();
        tp.setUser( passanger );
        tp.setTrip( trip );

        Mockito.when(tripRepository.checkTripExist(trip.getId(), TripStatus.PENDING))
                .thenReturn(true);

        Mockito.when(userRepository.checkUserExist(passanger.getId()))
                .thenReturn( java.util.Optional.ofNullable( passanger ) );

        Mockito.when(tripPassangerRepository.checkPassangerAppliedForTrip(passanger.getId(), trip.getId()))
                .thenReturn( java.util.Optional.ofNullable( tp ) );

        ApplyForTripRequest req = new ApplyForTripRequest(trip, passanger);
        List<ApplicationError> applicationErrors = validator.validate(req);

        assertEquals(1, applicationErrors.size());

        assertEquals("passanger", applicationErrors.get(0).getField() );
        assertEquals("Already applied", applicationErrors.get(0).getDescription());

    }

    @Test
    public void shouldReturnErrorWhenDriverAppliesAsPassanger() {
        User passanger = new User();
        passanger.setId((long) 6985);

        Trip trip = new Trip();
        trip.setId((long) 3256);
        trip.setUser( passanger );

        TripPassanger tp = new TripPassanger();
        tp.setUser( passanger );
        tp.setTrip( trip );

        Mockito.when(tripRepository.checkTripExist(trip.getId(), TripStatus.PENDING))
                .thenReturn(true);

        Mockito.when(userRepository.checkUserExist(passanger.getId()))
                .thenReturn( java.util.Optional.ofNullable( passanger ) );

        Mockito.when(tripPassangerRepository.checkPassangerAppliedForTrip(passanger.getId(), trip.getId()))
                .thenReturn( Optional.empty() );

        Mockito.when( tripRepository.getTripById(trip.getId() ))
                .thenReturn( java.util.Optional.ofNullable( trip ) );

        ApplyForTripRequest req = new ApplyForTripRequest(trip, passanger);
        List<ApplicationError> applicationErrors = validator.validate(req);

        assertEquals(1, applicationErrors.size());

        assertEquals("driverId", applicationErrors.get(0).getField() );
        assertEquals("Driver cannot be passanger", applicationErrors.get(0).getDescription());

    }


}
