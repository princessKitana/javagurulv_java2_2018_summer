package lv.javaguru.java2.web.mvc;

import lv.javaguru.java2.buisnesslogic.vehicle.addvehicle.AddVehicleRequest;
import lv.javaguru.java2.buisnesslogic.vehicle.addvehicle.AddVehicleResponse;
import lv.javaguru.java2.buisnesslogic.vehicle.addvehicle.AddVehicleService;
import lv.javaguru.java2.buisnesslogic.vehicle.get.GetVehicleRequest;
import lv.javaguru.java2.buisnesslogic.vehicle.get.GetVehicleResponse;
import lv.javaguru.java2.buisnesslogic.vehicle.get.GetVehicleService;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import lv.javaguru.java2.web.dtos.TripDTO;
import lv.javaguru.java2.web.dtos.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class VehicleMVCController {

    @Autowired
    AddVehicleService addVehicleService;

    @Autowired
    GetVehicleService getVehicleService;

    @RequestMapping(value = "/vehicles/addVehicle", method = RequestMethod.GET)
    public ModelAndView showAddVehicleForm() {
        ModelAndView mav = new ModelAndView("addVehicle");
        mav.addObject("car", new VehicleDTO( ));
        return mav;
    }

    @RequestMapping(value = "/vehicles/addVehicleProcess", method = RequestMethod.POST)
    public ModelAndView addVehicle(@ModelAttribute("car") VehicleDTO vehicleDTO) {

        Vehicle car = new Vehicle();
        User user = new User();
        user.setId(vehicleDTO.getDriverId());

        car.setUser(user);
        car.setModel(vehicleDTO.getModel());
        car.setColor(vehicleDTO.getColor());
        car.setYear(vehicleDTO.getYear());
        car.setRegNumber(vehicleDTO.getRegNumber());

        AddVehicleRequest request = new AddVehicleRequest(car);

        AddVehicleResponse response = addVehicleService.addVehicle(request);

        vehicleDTO.setId(response.getVehicleId());
        return new ModelAndView( "vehicle", "vehicle", vehicleDTO);

    }

    @RequestMapping(value = "/vehicles/{id}", method = RequestMethod.GET)
    public ModelAndView getVehicle(@PathVariable("id") Long vehicleId) {
        GetVehicleRequest request = new GetVehicleRequest(vehicleId);
        GetVehicleResponse response = getVehicleService.get(request);

        return new ModelAndView( "vehicle", "car", response.getCar() );

    }

}
