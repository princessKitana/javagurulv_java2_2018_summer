package lv.javaguru.java2.acceptancetests.applyForTripControllerAcceptanceTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.java2.web.dtos.ApplicationExceptionDTO;
import lv.javaguru.java2.web.dtos.TripPassangerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ApplyForTripControllerActions {

    private static final String BASE_URL = "http://localhost:8080/java2/trip/apply";

    private RestTemplate restTemplate = new RestTemplate();

    public TripPassangerDTO createTripApplication() {
        TripPassangerDTO tp = new TripPassangerDTO();

        tp.setPassanger((long) 32); //Must exist in DB
        tp.setTrip((long) 53); //Must exist in DB

        return tp;
    }


    public TripPassangerDTO applyForTrip(TripPassangerDTO tp) {

        ResponseEntity<TripPassangerDTO> response =
                restTemplate.postForEntity(
                        BASE_URL,
                        tp,
                        TripPassangerDTO.class);

        return response.getBody();
    }


    public ResponseEntity<ApplicationExceptionDTO> applyForTripWithException(TripPassangerDTO tp) {

        try {
            restTemplate.postForEntity(
                    BASE_URL,
                    tp,
                    ApplicationExceptionDTO.class);
        } catch (HttpClientErrorException e) {
            String responseBody = e.getResponseBodyAsString();
            return ResponseEntity
                    .status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(convertToAppException(responseBody));
        }
        throw new RuntimeException("Apply for Trip not failed with exception but should be!");
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
