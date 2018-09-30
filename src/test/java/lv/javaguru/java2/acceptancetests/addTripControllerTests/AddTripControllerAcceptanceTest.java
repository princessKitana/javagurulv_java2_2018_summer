package lv.javaguru.java2.acceptancetests.addTripControllerTests;

import lv.javaguru.java2.acceptancetests.addTripControllerTests.AddTripControllerActions;
import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import lv.javaguru.java2.web.dtos.TripDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.sql.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddTripControllerAcceptanceTest {

    private AddTripControllerActions actions = new AddTripControllerActions();

    @Test
    public void addTrip() {
        TripDTO req = actions.createTrip();
        TripDTO resp = actions.addTrip(req);
        assertTrue(resp.getId() != null);

    }


    @Test
    public void getTrip() {
        TripDTO req = actions.createTrip();
        TripDTO resp = actions.addTrip(req);

        TripDTO trip = actions.getTrip(resp.getId());
        Assert.assertEquals(resp.getId(), trip.getId());
    }


    @Test
    public void getAllTrips() {

        List<TripDTO> trips1 = actions.getAllTrips();

        TripDTO req = actions.createTrip();
        TripDTO resp = actions.addTrip(req);

        List<TripDTO> trips2 = actions.getAllTrips();
        Assert.assertEquals(trips1.size(), trips2.size()-1 );
    }

    @Test
    public void checkOriginAndDestinationNotBlank() {
        TripDTO req = actions.createTrip();
        req.setOrigin( "" );
        req.setDestination( null );
        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.addTripWithException(req);

        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(2, errors.size());
        assertEquals( "origin", errors.get(0).getField());
        assertEquals("Cannot be empty", errors.get(0).getDescription());
        assertEquals( "destination", errors.get(1).getField());
        assertEquals("Cannot be empty", errors.get(1).getDescription());
    }

    @Test
    public void checkPricevalid() {
        TripDTO req = actions.createTrip();
        req.setPrice( 150.00 );
        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.addTripWithException(req);

        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "price", errors.get(0).getField());
        assertEquals("Must be from 0.00 to 100.00", errors.get(0).getDescription());

    }

    @Test
    public void checkTimeValid() {
        TripDTO req = actions.createTrip();
        req.setTime("126:585:0");
        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.addTripWithException(req);

        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "time", errors.get(0).getField());
        assertEquals("Not not valid", errors.get(0).getDescription());

    }
    @Test
    public void checkDateInPast() {
        TripDTO req = actions.createTrip();
        req.setDate(  "2001-01-01"  );
        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.addTripWithException(req);

        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "date", errors.get(0).getField());
        assertEquals("Date must be in future", errors.get(0).getDescription());

    }


    @Test
    public void checkDateInvalid() {
        TripDTO req = actions.createTrip();
        req.setDate(  "200686-01-01"  );
        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.addTripWithException(req);

        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "date", errors.get(0).getField());
        assertEquals("Date not valid", errors.get(0).getDescription());

    }


    @Test
    public void checkDriverNotExists() {
        TripDTO req = actions.createTrip();
        req.setDriverId( (long) 12589753 );
        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.addTripWithException(req);

        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(2, errors.size());
        assertEquals( "driverId", errors.get(0).getField());
        assertEquals("Driver not found", errors.get(0).getDescription());

        assertEquals( "vehicleId", errors.get(1).getField());
        assertEquals("Vehicle do not belongs to driver", errors.get(1).getDescription());

    }


    @Test
    public void checkPassengerCountMoreThanZero() {
        TripDTO req = actions.createTrip();
        req.setPassangerCount( "0");
        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.addTripWithException(req);

        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "passangerCount", errors.get(0).getField());
        assertEquals("Must be more than 0", errors.get(0).getDescription());

    }


}
