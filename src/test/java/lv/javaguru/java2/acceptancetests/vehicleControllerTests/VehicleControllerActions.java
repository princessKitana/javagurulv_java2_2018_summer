package lv.javaguru.java2.acceptancetests.vehicleControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import lv.javaguru.java2.web.dtos.VehicleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class VehicleControllerActions {

    private static final String BASE_URL = "http://localhost:8080/java2/vehicle";

    private RestTemplate restTemplate = new RestTemplate();

    public VehicleDTO createVehicle() {
        VehicleDTO car = new VehicleDTO();
        car.setDriverId((long) 31); //Must exist in DB
        car.setRegNumber("MK-8597");
        car.setYear("2018");
        car.setModel("Audi A4");
        car.setColor("Black");
        return car;
    }

    public VehicleDTO addVehicle(VehicleDTO car) {

        ResponseEntity<VehicleDTO> response =
                restTemplate.postForEntity(
                        BASE_URL,
                        car,
                        VehicleDTO.class);

        return response.getBody();
    }

    public VehicleDTO getVehicle(Long vehicleId) {
        ResponseEntity<VehicleDTO> response =
                restTemplate.getForEntity(
                        BASE_URL + "/" + vehicleId, VehicleDTO.class);
        return response.getBody();
    }

    public ResponseEntity<ApplicationExceptionDTO> createVehicleWithException(VehicleDTO car) {

        try {
            restTemplate.postForEntity(
                    BASE_URL,
                    car,
                    ApplicationExceptionDTO.class);
        } catch (HttpClientErrorException e) {
            String responseBody = e.getResponseBodyAsString();
            return ResponseEntity
                    .status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(convertToAppException(responseBody));
        }
        throw new RuntimeException("Add vehicle not failed with exception but should be!");
    }

    private ApplicationExceptionDTO convertToAppException(String response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response, ApplicationExceptionDTO.class);
        } catch (IOException e) {
            throw new RuntimeException("JSON parsing exception", e);
        }
    }
}
