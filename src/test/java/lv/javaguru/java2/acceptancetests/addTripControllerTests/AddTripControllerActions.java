package lv.javaguru.java2.acceptancetests.addTripControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import lv.javaguru.java2.web.dtos.TripDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AddTripControllerActions {

    private static final String BASE_URL = "http://localhost:8080/java2/trip";

    private RestTemplate restTemplate = new RestTemplate();

    public TripDTO createTrip() {
        TripDTO trip = new TripDTO();

        trip.setDriverId((long) 31); //Must exist in DB
        trip.setVehicleId((long) 21); //Must exist in DB
        trip.setOrigin("Riga");
        trip.setDestination("Liepaja");
        trip.setDate("2022-07-06");
        trip.setTime("14:00:00");
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setPassangerCount("2");

        return trip;
    }


    public TripDTO addTrip(TripDTO trip) {

        ResponseEntity<TripDTO> response =
                restTemplate.postForEntity(
                        BASE_URL,
                        trip,
                        TripDTO.class);

        return response.getBody();
    }

    public TripDTO getTrip(Long tripId) {
        ResponseEntity<TripDTO> response =
                restTemplate.getForEntity(
                        BASE_URL + "/" + tripId, TripDTO.class);
        return response.getBody();
    }



    public List<TripDTO> getAllTrips() {

        ResponseEntity<List<TripDTO>> response =
                restTemplate.exchange(
                        BASE_URL + "/",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<TripDTO>>() {
                        });
        List<TripDTO> trips = response.getBody();
        return trips;
    }

    public ResponseEntity<ApplicationExceptionDTO> addTripWithException(TripDTO trip) {

        try {
            restTemplate.postForEntity(
                    BASE_URL,
                    trip,
                    ApplicationExceptionDTO.class);
        } catch (HttpClientErrorException e) {
            String responseBody = e.getResponseBodyAsString();
            return ResponseEntity
                    .status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(convertToAppException(responseBody));
        }
        throw new RuntimeException("Add Trip not failed with exception but should be!");
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
