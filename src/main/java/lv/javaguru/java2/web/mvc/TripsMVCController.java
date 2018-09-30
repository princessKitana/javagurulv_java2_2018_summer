package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripService;
import lv.javaguru.java2.buisnesslogic.trip.get.GetAllTripsResponse;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Component
public class TripsMVCController implements MVCController{

    @Autowired
    GetTripService getTripService;

    @Autowired
    AddTripService addTripService;

    @Override
    public MVCModel processGet(HttpServletRequest request) {

            GetAllTripsResponse response = getTripService.getAllTrips();

            return new MVCModel("/trips.jsp", response);

    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

}
