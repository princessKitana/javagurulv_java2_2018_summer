package lv.javaguru.java2.applyForTripTests;

import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.buisnesslogic.applyForTrip.ApplyForTripRequest;
import lv.javaguru.java2.buisnesslogic.applyForTrip.ApplyForTripValidator;
import lv.javaguru.java2.buisnesslogic.applyForTrip.ApplyForTripValidatorImpl;
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
import lv.javaguru.java2.Error;
import org.springframework.beans.factory.annotation.Autowired;

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
        List<Error> errors = validator.validate(req);

        assertEquals(2, errors.size());
        assertEquals("userId", errors.get(0).getField() );
        assertEquals("Cannot be empty", errors.get(0).getDescription());

        assertEquals("tripId", errors.get(1).getField() );
        assertEquals("Cannot be empty", errors.get(1).getDescription());

    }


    @Test
    public void shouldReturnErrorWhenTripAndPassangerDoesNotExist() {
        User passanger = new User();
        passanger.setId((long) 3);
        Trip trip = new Trip();
        trip.setId((long) 6);

        Mockito.when(tripRepository.checkTripExist(trip.getId(), String.valueOf(TripStatus.PENDING)))
               .thenReturn(false);
        Mockito.when(userRepository.checkUserExist(passanger.getId()))
                .thenReturn(false);

        ApplyForTripRequest req = new ApplyForTripRequest(trip, passanger);
        List<Error> errors = validator.validate(req);

        assertEquals(2, errors.size());

        assertEquals("userId", errors.get(0).getField() );
        assertEquals("Does not exist", errors.get(0).getDescription());

        assertEquals("tripId", errors.get(1).getField() );
        assertEquals("Does not exist", errors.get(1).getDescription());

    }


}
