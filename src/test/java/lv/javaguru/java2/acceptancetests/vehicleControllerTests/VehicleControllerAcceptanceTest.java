package lv.javaguru.java2.acceptancetests.vehicleControllerTests;


import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import lv.javaguru.java2.web.dtos.VehicleDTO;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VehicleControllerAcceptanceTest {

    private VehicleControllerActions actions = new VehicleControllerActions();

    @Test
    public void addVehicle() {
        VehicleDTO car = actions.createVehicle();
        VehicleDTO userResp = actions.addVehicle(car);
        assertTrue(userResp.getId() != null);
        assertTrue(userResp.getColor().equals(car.getColor()));
        assertTrue(userResp.getModel().equals(car.getModel()));
        assertTrue(userResp.getRegNumber().equals(car.getRegNumber()));
        assertTrue(userResp.getYear().equals(car.getYear()));
        assertTrue(userResp.getDriverId().equals(car.getDriverId()));

    }

    @Test
    public void getVehicle() {

        VehicleDTO carPost = actions.addVehicle(actions.createVehicle());

        VehicleDTO carGet = actions.getVehicle(carPost.getId());
        assertEquals(carGet.getColor(), carPost.getColor());
        assertEquals(carGet.getModel(), carPost.getModel());
        assertEquals(carGet.getRegNumber(), carPost.getRegNumber());
        assertEquals(carGet.getYear(), carPost.getYear());
        assertEquals(carGet.getDriverId(), carPost.getDriverId());
    }

    @Test
    public void createVehicleWithDriverIdDoesNotExist() {
        VehicleDTO car = actions.createVehicle();
        car.setDriverId(generateRandomString());

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.createVehicleWithException(car);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals( "driverId", errors.get(0).getField());
        assertEquals("Does not exist", errors.get(0).getDescription());
    }

    @Test
    public void createVehicleWithEmptyModel() {
        VehicleDTO car = actions.createVehicle();
        car.setModel(null);

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.createVehicleWithException(car);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals("model", errors.get(0).getField()) ;
        assertEquals("Cannot be empty", errors.get(0).getDescription() );
    }

    @Test
    public void createVehicleWithEmptyColor() {
        VehicleDTO car = actions.createVehicle();
        car.setColor("");

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.createVehicleWithException(car);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals("color", errors.get(0).getField()) ;
        assertEquals("Cannot be empty", errors.get(0).getDescription() );
    }

    @Test
    public void createVehicleWithEmptyDriverId() {
        VehicleDTO car = actions.createVehicle();
        car.setDriverId(null);

        ResponseEntity<ApplicationExceptionDTO> responseWithException = actions.createVehicleWithException(car);
        assertEquals(responseWithException.getStatusCode(), HttpStatus.FORBIDDEN);
        ApplicationExceptionDTO appEx = responseWithException.getBody();
        List<ApplicationError> errors = appEx.getErrors();
        assertEquals(1, errors.size());
        assertEquals("driverId", errors.get(0).getField()) ;
        assertEquals("Cannot be empty", errors.get(0).getDescription() );
    }

    @Test
    public void createUserWithEmptyYearAndRegNumber() {
        VehicleDTO car = actions.createVehicle();
        car.setYear("");
        car.setRegNumber("");

        VehicleDTO carResp = actions.createVehicle();
        assertTrue(carResp.getId() != null);
    }

    private Long generateRandomString() {
        Random random = new Random();
        return (Long) random.nextLong();
    }
}
