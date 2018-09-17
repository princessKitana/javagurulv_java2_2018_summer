package lv.javaguru.java2.web;

import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripService;
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

@RestController
public class AddTripController {

    @Autowired
    AddTripService addTripService;

    @Autowired
    GetTripService getTripService;

    @ResponseBody
    @PostMapping(value = "/trip")
    public ResponseEntity<TripDTO> addTrip(@RequestBody TripDTO tripDTO) {

        Trip trip = new Trip();
        User driver = new User();
        driver.setId(tripDTO.getDriverId());
        Vehicle car = new Vehicle();
        car.setId(tripDTO.getVehicleId());
        trip.setUser(driver);
        trip.setCar(car);
        trip.setOrigin(tripDTO.getOrigin());
        trip.setDestination(tripDTO.getDestination());
        trip.setDate(tripDTO.getDate());
        trip.setTime(tripDTO.getTime());
        trip.setPrice(tripDTO.getPrice());
        trip.setComment(tripDTO.getComment());

        AddTripRequest request = new AddTripRequest(trip);

        AddTripResponse response = addTripService.addTrip(request);
        tripDTO.setId(response.getTripId());
        return ResponseEntity.ok(tripDTO);
    }

    @RequestMapping(value = "/trip/{id}", method = RequestMethod.GET)
    public TripDTO getUser(@PathVariable("id") Long tripId) {
        GetTripRequest request = new GetTripRequest(tripId);
        GetTripResponse response = getTripService.get(request);
        return response.getTrip();
    }



}
