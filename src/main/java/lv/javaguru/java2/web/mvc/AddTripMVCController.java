package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripService;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripRequest;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripResponse;
import lv.javaguru.java2.buisnesslogic.trip.get.GetTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Component
public class AddTripMVCController implements  MVCController{

    @Autowired
    GetTripService getTripService;

    @Autowired
    AddTripService addTripService;

    public MVCModel processGet(HttpServletRequest request) {
//    String id = request.getParameter("id");
//        GetTripRequest req = new GetTripRequest(Long.valueOf(id));
//
//        GetTripResponse response = getTripService.get(req);
//
//        return new MVCModel("/trip.jsp", response);

        //throw new UnsupportedOperationException();
        return new MVCModel("/addTrip.jsp", "");

    }


    public MVCModel processPost(HttpServletRequest request) {
        AddTripRequest addTriprequest = new AddTripRequest(  );

        addTriprequest.setOrigin( request.getParameter("origin"));
        addTriprequest.setDestination( ( request.getParameter("destination")));
        addTriprequest.setDate( ( request.getParameter("date")));
        addTriprequest.setTime( ( request.getParameter("time")));
        addTriprequest.setPrice( ( request.getParameter("price")));
        addTriprequest.setVehicleId( request.getParameter("vehicleId"));
        addTriprequest.setDriverId( ( request.getParameter("driverId")));
        addTriprequest.setPassangerCount( ( request.getParameter("passangerCount")));
        addTriprequest.setComment( ( request.getParameter("comment")));

        AddTripResponse addTripResponse = addTripService.addTrip(addTriprequest);

        return new MVCModel("/addTrip.jsp", addTripResponse);

    }



}

