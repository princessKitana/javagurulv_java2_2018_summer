package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripService;
import lv.javaguru.java2.buisnesslogic.trip.get.GetAllTripsResponse;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripService;
import lv.javaguru.java2.buisnesslogic.vehicle.get.GetVehicleService;
import lv.javaguru.java2.buisnesslogic.vehicle.getAll.GetAllVehiclesRequest;
import lv.javaguru.java2.buisnesslogic.vehicle.getAll.GetAllVehiclesResponse;
import lv.javaguru.java2.buisnesslogic.vehicle.getAll.GetAllVehiclesService;
import lv.javaguru.java2.web.dtos.TripDTO;
import lv.javaguru.java2.web.dtos.TripPassangerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TripsMVCController{

    @Autowired
    GetTripService getTripService;

    @Autowired
    AddTripService addTripService;

    @Autowired
    GetAllVehiclesService getAllVehiclesService;

    @RequestMapping(value = "/trips", method = RequestMethod.GET)
    public ModelAndView getTrips() {
        GetAllTripsResponse response = getTripService.getAllTrips();
        List<TripDTO> trips = response.getTrips();
        return new ModelAndView( "trips", "trips", trips );

    }

    @RequestMapping(value = "/trips/{id}", method = RequestMethod.GET)
    public ModelAndView getTrip(@PathVariable("id") Long tripId) {
        GetTripRequest request = new GetTripRequest(tripId);
        GetTripResponse response = getTripService.get(request);
        ModelAndView mav = new ModelAndView("trip");
        mav.addObject(  "tripDTO", response.getTrip() );
        mav.addObject("tpDTO", new TripPassangerDTO() );
        return mav;


    }

    @RequestMapping(value = "/trips/addTrip", method = RequestMethod.GET)
    public ModelAndView showAddTripUserForm(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");

        GetAllVehiclesRequest req = new GetAllVehiclesRequest( userId );
        GetAllVehiclesResponse resp = getAllVehiclesService.get(req);

        ModelAndView mav = new ModelAndView("addTrip");
        mav.addObject("trip", new TripDTO( ));
        mav.addObject("vehicles", resp.getCars());

        return mav;
    }

    @RequestMapping(value = "/trips/addTripProcess", method = RequestMethod.POST)
    public ModelAndView addTrip(HttpServletRequest request,
                                @ModelAttribute("tripDTO") TripDTO trip ) {

        AddTripRequest req = new AddTripRequest();

        req.setDriverId( String.valueOf( trip.getDriverId() ) );
        req.setVehicleId( String.valueOf( trip.getVehicleId() ) );
        req.setDestination(trip.getDestination());
        req.setDate(trip.getDate());

        req.setTime(trip.getTime());
        req.setPrice(String.valueOf(trip.getPrice()));
        req.setComment(trip.getComment());
        req.setPassangerCount(trip.getPassangerCount());
        req.setOrigin(trip.getOrigin());

        AddTripResponse resp = addTripService.addTrip(req);

        ModelAndView mav = new ModelAndView("trip");
        trip.setId(resp.getTripId());
        mav.addObject("tripDTO", trip );
        return mav;


    }

}
