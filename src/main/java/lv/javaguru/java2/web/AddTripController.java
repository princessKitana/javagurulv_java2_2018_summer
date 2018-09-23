package lv.javaguru.java2.web;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripService;
import lv.javaguru.java2.buisnesslogic.trip.get.GetAllTripsResponse;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripService;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import lv.javaguru.java2.web.dtos.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class AddTripController {

    @Autowired
    AddTripService addTripService;

    @Autowired
    GetTripService getTripService;

    @ResponseBody
    @PostMapping(value = "/trip")
    public ResponseEntity<TripDTO> addTrip(@RequestBody TripDTO tripDTO) {

        AddTripRequest request = new AddTripRequest(  );
        request.setDriverId(tripDTO.getDriverId());
        request.setVehicleId(tripDTO.getVehicleId());
        request.setDestination(tripDTO.getDestination());
        request.setDate(tripDTO.getDate());

        request.setTime(tripDTO.getTime());
        request.setPrice(tripDTO.getPrice());
        request.setComment(tripDTO.getComment());
        request.setPassangerCount(tripDTO.getPassangerCount());
        request.setOrigin(tripDTO.getOrigin());

        AddTripResponse response = addTripService.addTrip(request);
        tripDTO.setId(response.getTripId());
        tripDTO.setStatus( String.valueOf( TripStatus.PENDING ) );
        return ResponseEntity.ok(tripDTO);
    }

    @RequestMapping(value = "/trip/{id}", method = RequestMethod.GET)
    public TripDTO getTrip(@PathVariable("id") Long tripId) {
        GetTripRequest request = new GetTripRequest(tripId);
        GetTripResponse response = getTripService.get(request);
        return response.getTrip();
    }

    @RequestMapping(value = "/trip", method = RequestMethod.GET)
    public List<TripDTO> getTrips() {
        GetAllTripsResponse response = getTripService.getAllTrips();
        return response.getTrips();
    }



}
