package lv.javaguru.java2.acceptancetests.applyForTripControllerAcceptanceTest;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import lv.javaguru.java2.web.dtos.TripPassangerDTO;
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
        req.setPassanger( (long) 48 ); //Must be in DB
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

    @Test
    public void passengerApplyForTripSecondTime() {
        TripPassangerDTO req = actions.createTripApplication();
        TripPassangerDTO req2 = actions.createTripApplication();

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.applyForTripWithException(req2);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "passanger", errors.get(0).getField());
        assertEquals("Already applied", errors.get(0).getDescription());
    }

    @Test
    public void checkNotPendingTrip() {
        TripPassangerDTO req = actions.createTripApplication();
        req.setTrip( (long) 23 ); //Must be not Pending Trip in DB
        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.applyForTripWithException(req);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "tripId", errors.get(0).getField());
        assertEquals("Does not exist", errors.get(0).getDescription());
    }

    @Test
    public void passangerAppliedIsTripDriver() {
        TripPassangerDTO req = actions.createTripApplication();
        req.setPassanger( (long) 31 ); //passangerId must be in DB as trip driverId
        req.setTrip( (long) 40 );

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.applyForTripWithException(req);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "driverId", errors.get(0).getField());
        assertEquals("Driver cannot be passanger", errors.get(0).getDescription());
    }


}
