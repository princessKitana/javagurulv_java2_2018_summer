package lv.javaguru.java2.acceptancetests.ApplyForTripControllerAcceptanceTest;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import lv.javaguru.java2.web.dtos.TripPassangerDTO;
import lv.javaguru.java2.web.dtos.UserDTO;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ApplyForTripControllerAcceptanceTest {

    private ApplyForTripControllerActions actions = new ApplyForTripControllerActions();

    @Test
    public void applyForTrip() {
        TripPassangerDTO req = actions.createTripApplication();
        TripPassangerDTO resp = actions.applyForTrip(req);
        assertTrue(resp.getId() != null);

    }

    @Test
    public void nonExistingPassangerApplyForTrip() {
        TripPassangerDTO req = actions.createTripApplication();
        req.setPassanger( (long) 489652336 );
        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.applyForTripWithException(req);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "userId", errors.get(0).getField());
        assertEquals("Does not exist", errors.get(0).getDescription());
    }

    @Test
    public void passengerApplyForNonExiststingTrip() {
        TripPassangerDTO req = actions.createTripApplication();
        req.setTrip( (long) 489652336 );

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.applyForTripWithException(req);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "tripId", errors.get(0).getField());
        assertEquals("Does not exist", errors.get(0).getDescription());
    }

//TODO not PENDING trip?
    //TODO test check passanger alreay apllied?
    //TODO test  check passanger apllied is not trip driver
    //TODO test check passanger seats availiable
    //TODO test check trip is pending

}
