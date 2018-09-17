package lv.javaguru.java2.web;

import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripService;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripResponse;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.TripPassanger;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.web.dtos.TripDTO;
import lv.javaguru.java2.web.dtos.TripPassangerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplyForTripController {


    @Autowired
    ApplyForTripService applyForTripService;

    @ResponseBody
    @PostMapping(value = "/trip/apply")
    public ResponseEntity<TripPassangerDTO> applyForTrip(@RequestBody TripPassangerDTO tpDTO) {

        User passanger =new User();
        passanger.setId( tpDTO.getPassanger() );

        Trip trip  = new Trip();
        trip.setId( tpDTO.getTrip() );

        ApplyForTripRequest request = new ApplyForTripRequest(trip, passanger);

        ApplyForTripResponse response = applyForTripService.applyForTrip(request);
        tpDTO.setId(response.getTripId());
        return ResponseEntity.ok(tpDTO);
    }

    ///?
//    @RequestMapping(value = "/trip/aplly/{id}", method = RequestMethod.GET)
//    public TripDTO getUsersAppliedForTrip(@PathVariable("id") Long tripId) {
//         request = new (tripId);
//        GetTripResponse response = getTripService.get(request);
//        return response.getTrip();
//    }

}
