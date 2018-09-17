package lv.javaguru.java2.applyForTripTests;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripValidator;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripValidatorImpl;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ApplyForTripValidatorImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    TripRepository tripRepository;

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
                .thenReturn( java.util.Optional.ofNullable( passanger ) );

        ApplyForTripRequest req = new ApplyForTripRequest(trip, passanger);
        List<ApplicationError> applicationErrors = validator.validate(req);

        assertEquals(2, applicationErrors.size());

        assertEquals("userId", applicationErrors.get(0).getField() );
        assertEquals("Does not exist", applicationErrors.get(0).getDescription());

        assertEquals("tripId", applicationErrors.get(1).getField() );
        assertEquals("Does not exist", applicationErrors.get(1).getDescription());

    }


}
