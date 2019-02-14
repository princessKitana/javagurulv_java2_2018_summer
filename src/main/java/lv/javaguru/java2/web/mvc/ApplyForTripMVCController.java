package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.applyForTrip.ApplyForTripService;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.web.dtos.TripPassangerDTO;
import lv.javaguru.java2.web.dtos.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplyForTripMVCController {
    @Autowired
    ApplyForTripService applyForTripService;

    @RequestMapping(value = "/trips/applyForTripProcess", method = RequestMethod.POST)
    public ModelAndView applyForTripProcess(@ModelAttribute("tpDTO") TripPassangerDTO tpDTO){

        User passanger =new User();
        passanger.setId( tpDTO.getPassanger() );

        Trip trip  = new Trip();
        trip.setId( tpDTO.getTrip() );

        ApplyForTripRequest request = new ApplyForTripRequest(trip, passanger);

        ApplyForTripResponse response = applyForTripService.applyForTrip(request);
        tpDTO.setId(response.getTripId());

        ModelAndView mav = new ModelAndView("trip");
        mav.addObject("tpDTO", tpDTO);
        return mav;

    }

}
